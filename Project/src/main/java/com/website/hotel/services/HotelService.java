package com.website.hotel.services;

import com.website.hotel.domain.BookingEntity;
import com.website.hotel.domain.HotelEntity;
import com.website.hotel.domain.RoomEntity;

public interface HotelService {
    HotelEntity AddHotel(HotelEntity hotel);
    RoomEntity AddRoom(RoomEntity room);
    BookingEntity BookingRoom(BookingEntity bookingEntity);


}
