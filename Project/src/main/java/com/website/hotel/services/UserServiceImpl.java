package com.website.hotel.services;

import com.website.hotel.domain.UserEntity;
import com.website.hotel.exceptions.AtAuthException;
import com.website.hotel.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

   final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserEntity validateUser(String login, String password) throws AtAuthException {
        Optional<UserEntity> user = userRepository.findByLoginAndPassword(login, password);
        if(!user.isPresent())
            return null;
        return user.get();

    }

    @Override
    public UserEntity registerUser(UserEntity userEntity) throws AtAuthException {
        userEntity.setPassword(DigestUtils.md5DigestAsHex(userEntity.getPassword().getBytes()));
       Pattern p = Pattern.compile("^\\w+@[A-Za-z]+\\.[a-z]{0,4}$");
       if(!p.matcher(userEntity.getEmail()).matches())
          throw  new AtAuthException("Not valid Email");

      if(userRepository.findByLogin(userEntity.getLogin()).isPresent())
          throw  new AtAuthException("Login already is used");

      if(userEntity.getPassword().length() < 5)
          throw new AtAuthException("Password is small");

       if(userRepository.findByEmail(userEntity.getEmail()).isPresent())
         throw  new AtAuthException("Email already is used");

        return userRepository.save(userEntity);
    }
    public boolean removeUser(String login, String password)
    {
        UserEntity user = validateUser(login, password);
        if(user == null)
            return false;
        userRepository.delete(user);
        return true;
    }
}
