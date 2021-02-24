package com.website.hotel.services;

import com.website.hotel.domain.User;
import com.website.hotel.exceptions.AtAuthException;
import com.website.hotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Repository
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String login, String Password) throws AtAuthException {
        return null;
    }

    @Override
    public User registerUser(String Name, String Surname, String Email, String Login, String Password) throws AtAuthException {
        Pattern p = Pattern.compile("^.+@.+\\..{0,4}$");
        if(!p.matcher(Email).matches())
            throw  new AtAuthException("Not valid Email");

        if(userRepository.FindByLogin(Login) > 0)
            throw  new AtAuthException("Login already is used");

        if(Password.length() < 5)
            throw new AtAuthException("Password is small");

        if(userRepository.FindByEmail(Email) > 0)
            throw  new AtAuthException("Email already is used");

       int Id = userRepository.create(Name,Surname,Email,Login,Password);
       return userRepository.findById(Id);
    }
}
