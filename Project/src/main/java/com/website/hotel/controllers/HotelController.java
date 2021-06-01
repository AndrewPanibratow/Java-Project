package com.website.hotel.controllers;

import com.website.hotel.domain.BookingEntity;
import com.website.hotel.domain.HotelEntity;
import com.website.hotel.domain.RoomEntity;
import com.website.hotel.services.HotelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    final HotelService hotelService;
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }
    @PostMapping("/addHotel")
    public HotelEntity addHotel(@RequestBody HotelEntity hotelEntityMap)
    {
        return hotelService.AddHotel(hotelEntityMap);
    }
    @PostMapping("/addRoom")
    public RoomEntity addRoom(@RequestBody RoomEntity roomEntityMap)
    {
        return hotelService.AddRoom(roomEntityMap);
    }
    @PostMapping("/addBooking")
    public BookingEntity addBooking(@RequestBody BookingEntity bookingEntityMap)
    {
        return hotelService.BookingRoom(bookingEntityMap);
    }
    @PostMapping("/removeHotel")
    public String removeHotel(@RequestBody int id){
        if(hotelService.RemoveHotel(id))
            return "Hotel was removed";
        return "Hotel not found";
    }
    @PostMapping("/removeRoom")
    public String removeRoom(@RequestBody int id){
        if(hotelService.RemoveRoom(id))
            return "Room was removed";
        return "Room not found";
    }
    @PostMapping("/getBookingByUser")
    public BookingEntity[] getAllBookingByUserLogin(String login){
        return hotelService.getBookingByUserLogin(login);
    }
}
