package com.website.hotel.repositories;

import com.website.hotel.domain.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface HotelRepository extends JpaRepository<HotelEntity, Long>
{
}
