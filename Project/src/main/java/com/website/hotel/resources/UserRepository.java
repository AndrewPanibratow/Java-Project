package com.website.hotel.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserRepository {
    @PostMapping("/register")
    public String registerUser (@RequestBody Map<String,Object> userMap)
    {
        String login = (String)userMap.get("login");
        String password = (String) userMap.get("password");
        return login + " "+ password;
    }
}
