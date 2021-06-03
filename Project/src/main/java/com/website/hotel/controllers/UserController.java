package com.website.hotel.controllers;

import com.website.hotel.domain.UserEntity;
import com.website.hotel.services.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Secured(value = "none")
@RequestMapping("/api/user")
public class UserController {

    final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String Admin(){
        return "Hello admin!";
    }

    @PostMapping("/register")
    public UserEntity registerUser (@RequestBody UserEntity userEntityMap)
    {
        userService.registerUser(userEntityMap);
        return userEntityMap;
    }
    @PostMapping("/remove")
    public String RemoveUser(@RequestBody Map<String, String> data)
    {
        String login = data.get("login");
        String password = data.get("password");
     if(userService.removeUser(login,password))
         return "User with login "+ data.get("login")+ " was deleted";
     else
         return "User doesn\'t register";
    }
    @PostMapping("/login")
    public String LoginUser(@RequestBody Map<String, String> data){
        String login = data.get("login");
        String password = data.get("password");
        UserEntity user = userService.validateUser(login, password);
        if(user != null)
            return "You login as "+user.getName() + " "+user.getSurname();
        else
            return "Not valid login or password";
    }
    @PostMapping("/getAllUser")
    public List<UserEntity> getUsers(){
        return userService.getAllUser();
    }
}
