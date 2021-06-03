package com.website.hotel.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/welcomePage")
    public String welcomePage(){
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Hello ");
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        sb.append(login+"</h1>");
        if(login != "anonymousUser")
        sb.append("<a href=\"\\logout\">logout</a>");
        return sb.toString();
    }
}
