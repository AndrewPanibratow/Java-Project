package com.website.hotel.services;

import com.website.hotel.domain.BookingEntity;
import com.website.hotel.domain.HotelEntity;
import com.website.hotel.domain.RoomEntity;
import com.website.hotel.exceptions.NotValidParametersException;
import com.website.hotel.repositories.HotelRepository;
import com.website.hotel.repositories.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HotelServiceImpl implements  HotelService {
   final HotelRepository hotelRepository;
   final RoomRepository roomRepository;
 public HotelServiceImpl(HotelRepository hotelRepository, RoomRepository roomRepository){
     this.hotelRepository = hotelRepository;
     this.roomRepository = roomRepository;
    }
    @Override
    public HotelEntity AddHotel(HotelEntity hotel) {
    hotelRepository.save(hotel);
    return hotel;
    }

    @Override
    public RoomEntity AddRoom(RoomEntity room) {
        if(room.getBeds_count() < 0)
            throw new NotValidParametersException("The number of beds must be greater than or equal to zero");
       roomRepository.save(room);
       return room;

    }

    @Override
    public BookingEntity BookingRoom(BookingEntity bookingEntity) {
        return null;
    }
}
