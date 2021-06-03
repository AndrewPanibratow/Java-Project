package com.website.hotel.services;

import com.website.hotel.domain.BookingEntity;
import com.website.hotel.domain.HotelEntity;
import com.website.hotel.domain.RoomEntity;

import java.util.List;

public interface HotelService {
    HotelEntity AddHotel(HotelEntity hotel);
    RoomEntity AddRoom(RoomEntity room);
    BookingEntity BookingRoom(BookingEntity bookingEntity);
    Boolean RemoveBooking(long id);
    Boolean RemoveHotel(long id);
    Boolean RemoveRoom(long id);
    BookingEntity[] getBookingByUserLogin(String login);
    RoomEntity[] getRoomsByHotelId(long id);
}
