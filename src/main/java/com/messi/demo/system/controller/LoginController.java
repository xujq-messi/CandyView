package com.messi.demo.system.controller;

import com.messi.demo.system.entity.User;
import com.messi.demo.system.exception.LoginException;
import com.messi.demo.system.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class) ;

    @Autowired
    IUserService userService ;

    @RequestMapping( value = { "", "index" }, method = RequestMethod.GET )
    public String index(Model model) {
        logger.info("index invoke") ;

        User user = new User() ;
        user.setName("messi");
        user.setPassword("messi@123");

        model.addAttribute("user", user) ;
        return "login" ;
    }

    @RequestMapping( value = { "login" }, method = RequestMethod.GET )
    public String login(@RequestParam("name") String user, @RequestParam("passwd") String passwd,Model model) throws Exception {
        logger.info("login invoke, user={} passwd = {}", user, passwd) ;

        // 校验用户名密码是否正确
        if( ! login(user,passwd) ) {
            throw new LoginException() ;
        }

        return "home" ;
    }

    private boolean login(String name, String passwd) {

        if(! StringUtils.hasText(name) || ! StringUtils.hasText(passwd))
            return false ;

        User user = userService.getUser(name) ;

        if( user == null ) {
            return false ;
        }

        return name.equals(user.getName()) && passwd.equals(user.getPassword()) ;
    }

}
