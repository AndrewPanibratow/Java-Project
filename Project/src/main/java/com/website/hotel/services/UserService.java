package com.website.hotel.services;

import com.website.hotel.domain.User;
import com.website.hotel.exceptions.AtAuthException;

public interface UserService {
    User validateUser(String login, String Password)  throws AtAuthException;
    User registerUser(User user)  throws AtAuthException;
    }
