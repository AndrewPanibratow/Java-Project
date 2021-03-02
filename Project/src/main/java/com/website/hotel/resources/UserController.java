package com.website.hotel.resources;

import com.website.hotel.domain.UserEntity;
import com.website.hotel.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserEntity registerUser (@RequestBody UserEntity userEntityMap)
    {
        userService.registerUser(userEntityMap);
        return userEntityMap;
    }
}
