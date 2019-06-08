package main.controllers;

import main.LoginHolder;
import main.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class MainController {

    @RequestMapping(value = "/login")
    public ModelAndView init(Model model) {
        model.addAttribute("login", new LoginHolder());
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public ModelAndView login(@Valid @ModelAttribute("login") LoginHolder loginData,
                              HttpServletResponse response, HttpServletRequest request) {
        if(!(Utils.isNull(loginData.getEmail()) || Utils.isNull(loginData.getPassword()))) {
            return new ModelAndView("dashboard");
        }

        return new ModelAndView("login");
    }
}
