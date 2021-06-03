package com.website.hotel.repositories;

import com.website.hotel.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
 Optional<UserEntity> findByEmail(String Email);
 Optional<UserEntity> findByLogin(String Login);
 Optional<UserEntity> findByLoginAndPassword(String Login, String Password);
 Optional<UserEntity> removeByLoginAndPassword(String Email, String Password);
}