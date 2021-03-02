package com.website.hotel.services;

import com.website.hotel.domain.UserEntity;
import com.website.hotel.exceptions.AtAuthException;
import com.website.hotel.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

   final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserEntity validateUser(String login, String Password) throws AtAuthException {
        return null;
    }

    @Override
    public UserEntity registerUser(UserEntity userEntity) throws AtAuthException {
       Pattern p = Pattern.compile("^.+@.+\\..{0,4}$");
       if(!p.matcher(userEntity.getEmail()).matches())
          throw  new AtAuthException("Not valid Email");
      //if(userRepository.FindByLogin(Login) > 0)
          //  throw  new AtAuthException("Login already is used");
      //  if(Password.length() < 5)
       //     throw new AtAuthException("Password is small");

       // if(userRepository.FindByEmail(Email) > 0)
        //    throw  new AtAuthException("Email already is used");

        if(userEntity == null)
            throw new AtAuthException("Not valid Email");
        userRepository.save(userEntity);

        return userEntity;
    }
}
