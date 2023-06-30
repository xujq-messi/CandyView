package com.messi.demo.core.config;

import com.messi.demo.core.exception.BusinesseException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinesseException.class)
    public String businessException(BusinesseException be, Model model) {

        model.addAttribute("message", be.getMessage()) ;
        return "error/business" ;
    }
}
