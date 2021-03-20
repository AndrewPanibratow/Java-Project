package com.website.hotel.repositories;

import com.website.hotel.domain.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    Optional<BookingEntity[]> findAllByHotelIdAndRoomId(long hotelId, long roomId);
}
