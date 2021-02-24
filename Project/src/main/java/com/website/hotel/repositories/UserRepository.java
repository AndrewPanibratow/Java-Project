package com.website.hotel.repositories;

import com.website.hotel.domain.User;

public interface UserRepository {
     Integer create(String Name, String Surname, String Email, String Login, String Password);
     User findById(int Id);
     Integer findByLoginAndPassword(String Login, String Password);
     Integer FindByLogin(String Login);
     Integer FindByEmail(String Email);
}
