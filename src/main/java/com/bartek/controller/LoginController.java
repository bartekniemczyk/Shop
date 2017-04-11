package com.bartek.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Bartek on 07.04.2017.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(Model model){
        model.addAttribute("error",true);
        return "login";
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(Model model){
        return "login";
    }
}
