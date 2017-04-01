package com.bartek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bartek on 22.03.2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String welcome(Model model){
        model.addAttribute("greetings","RTV EURO AGD");
        model.addAttribute("tagline","Zapraszamy do zakupów");
        return "welcome";
    }
}

