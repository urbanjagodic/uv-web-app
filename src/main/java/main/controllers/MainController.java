package main.controllers;

import main.LoginHolder;
import main.User;
import main.UserRepository;
import main.db_methods.UserMethods;
import main.utils.Logger;
import main.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/login";
    }

    @RequestMapping(value = "/login")
    public ModelAndView init(Model model, HttpSession session) {
        session.setAttribute("user", null);
        model.addAttribute("login", new LoginHolder());
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute("login") LoginHolder loginData,
                        HttpServletResponse response, HttpServletRequest request, Model model, HttpSession session) {


        if(!(Utils.isNull(loginData.getEmail()) || Utils.isNull(loginData.getPassword()))) {

            UserMethods userMethods = new UserMethods(userRepository);
            User user = userMethods.userExists(loginData.getEmail());
            if(user != null) {
                if(user.getPassword().equals(loginData.getPassword())) {
                    session.setAttribute("user", user);
                    Logger.log(Logger.TYPE.INFO, String.format("User '%s' logged in", user.getId()));
                    return "redirect:/dashboard";
                }
                else {
                    Logger.log(Logger.TYPE.WARNING, "Password is incorrect");
                }
            }
            else {
                Logger.log(Logger.TYPE.WARNING, "User doesn't exist!");
            }
        }
        return "login";
    }

    // Logs out and destroys current user session
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, Model model) {
        session.setAttribute("user", null);
        Logger.log(Logger.TYPE.INFO, "User logged out");
        return "redirect:/login";
    }
}
