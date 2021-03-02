package com.website.hotel.services;

import com.website.hotel.domain.UserEntity;
import com.website.hotel.exceptions.AtAuthException;

public interface UserService {
    UserEntity validateUser(String login, String Password)  throws AtAuthException;
    UserEntity registerUser(UserEntity userEntity)  throws AtAuthException;
    }
