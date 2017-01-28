package com.master.template.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by edsarp on 1/8/17.
 */
@Controller
public class homeCotrolller {

    @RequestMapping("/login")
    String login(){
        return "login";
    }

    @RequestMapping("/index")
    String index(){
        return "index";
    }
}
