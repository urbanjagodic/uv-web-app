package main.controllers;

import main.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class DashBoardController {

    // Gets userID from login or register page
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashBoard(Model model, @RequestParam("user_id") String userID) {
        System.out.println(userID);
        model.addAttribute("user_id", userID);
        return new ModelAndView("dashboard");
    }
}
