package com.messi.demo.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("/ferror")
    public String error() {
        return "error/error" ;
    }
}
