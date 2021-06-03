package com.website.hotel.repositories;

import com.website.hotel.domain.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findById(long Id);
}
