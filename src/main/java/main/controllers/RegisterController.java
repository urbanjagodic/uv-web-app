package main.controllers;

import main.User;
import main.db_methods.UserMethods;
import main.utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import main.UserRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class RegisterController {

    @Autowired
    private UserRepository userRepo;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerGet(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerPost(@Valid @ModelAttribute("user") User user, HttpServletRequest request,
                                     HttpSession session, Model model) {
        // validation
        UserMethods userMethods = new UserMethods(userRepo);
        if(userMethods.userInfoValid(user)) {
            userRepo.save(user);
            Logger.log(Logger.TYPE.INFO, "User added to db: " + user);
            session.setAttribute("user", user);
            Logger.log(Logger.TYPE.INFO, String.format("User '%s' logged in", user.getId()));
            return new ModelAndView("redirect:/dashboard");
        }
        else {
            Logger.log(Logger.TYPE.ERROR, "User input data is not valid!");
            return new ModelAndView("register");
        }

    }
}
