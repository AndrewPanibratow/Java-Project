package com.website.hotel.resources;

import com.website.hotel.domain.HotelEntity;
import com.website.hotel.domain.RoomEntity;
import com.website.hotel.domain.UserEntity;
import com.website.hotel.services.HotelService;
import com.website.hotel.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    final HotelService hotelService;
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }
    @PostMapping("/addhotel")
    public HotelEntity addHotel(@RequestBody HotelEntity hotelEntityMap)
    {
        return hotelService.AddHotel(hotelEntityMap);
    }
    @PostMapping("/addroom")
    public RoomEntity addRoom(@RequestBody RoomEntity roomEntityMap)
    {
        return hotelService.AddRoom(roomEntityMap);
    }
}
