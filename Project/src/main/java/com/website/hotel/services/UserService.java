package com.website.hotel.services;

import com.website.hotel.domain.UserEntity;
import com.website.hotel.exceptions.AtAuthException;

import java.util.List;

public interface UserService {
    UserEntity validateUser(String login, String password)  throws AtAuthException;
    UserEntity registerUser(UserEntity userEntity)  throws AtAuthException;
    boolean removeUser(String login, String password);
    List<UserEntity> getAllUser();
    }
