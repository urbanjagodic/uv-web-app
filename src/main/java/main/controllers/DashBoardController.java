package main.controllers;

import main.User;
import main.UserRepository;
import main.db_methods.UserMethods;
import main.utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class DashBoardController {

    @Autowired
    private UserRepository userRepo;

    // Gets userID from login or register page
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashBoard(Model model, HttpSession session) {
        User currentUser =  (User) session.getAttribute("user");
        if(currentUser != null) {
            model.addAttribute("user", currentUser);
            return "dashboard";
        }
        return "not_authorized";
    }

    @RequestMapping(value = "/dashboard/changeAvatar",method = RequestMethod.GET)
    public String changeAvatar(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user != null) {
            model.addAttribute("user", user);
            return "change_avatar";
        }
        return "not_authorized";
    }

    @RequestMapping(value = "/dashboard/changeAvatar",method = RequestMethod.POST)
    public String changeAvatarPost(@RequestParam("avatar") String avatar, Model model, HttpSession session) {

        UserMethods userMethods = new UserMethods(userRepo);
        User user = (User) session.getAttribute("user");
        if(user != null) {
            avatar = avatar.replace(" ", "+");
            User updatedUser = userMethods.changeAvatar(user.getId(), avatar);
            Logger.log(Logger.TYPE.INFO, String.format("User image updated for user %s", user.getId()));
            session.setAttribute("user", updatedUser);
            return "redirect:/dashboard";
        }
        return "not_authorized";
    }


}
