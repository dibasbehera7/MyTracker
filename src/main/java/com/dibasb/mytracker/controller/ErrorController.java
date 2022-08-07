package com.dibasb.mytracker.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("error")
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException
            (HttpServletRequest request, Exception ex) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("exception", ex.getLocalizedMessage());
        mv.addObject("url", request.getRequestURL());

        mv.setViewName("error");
        return mv;
    }

}
