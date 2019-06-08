package main.controllers;

import main.User;
import main.UserRepository;
import main.db_methods.UserMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DashBoardController {

    @Autowired
    private UserRepository userRepo;

    // Gets userID from login or register page
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashBoard(Model model, @RequestParam("user_id") String userID) {
        UserMethods userMethods = new UserMethods(userRepo);
        if(userMethods.getUserByID(userID) != null) {
            model.addAttribute("user_id", userID);
            return "dashboard";
        }
        return "not_authorized";
    }
}
