package com.website.hotel.security;

import com.website.hotel.domain.RoleEntity;
import com.website.hotel.domain.UserEntity;
import com.website.hotel.repositories.RoleRepository;
import com.website.hotel.repositories.UserRepository;
import com.website.hotel.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    CustomUserDetailsService(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByLogin(s).orElseThrow(()->new UsernameNotFoundException("User not found!"));
        RoleEntity roleEntity = roleRepository.findById(userEntity.getRoleId());
        return new CustomUserDetails(userEntity,roleEntity.getRoleName());
    }

}
