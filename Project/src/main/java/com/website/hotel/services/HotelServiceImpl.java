package com.website.hotel.services;

import com.website.hotel.domain.BookingEntity;
import com.website.hotel.domain.HotelEntity;
import com.website.hotel.domain.RoomEntity;
import com.website.hotel.domain.UserEntity;
import com.website.hotel.exceptions.EmptyResult;
import com.website.hotel.exceptions.NotValidParametersException;
import com.website.hotel.repositories.BookingRepository;
import com.website.hotel.repositories.HotelRepository;
import com.website.hotel.repositories.RoomRepository;
import com.website.hotel.repositories.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class HotelServiceImpl implements  HotelService {
   final HotelRepository hotelRepository;
   final RoomRepository roomRepository;
   final BookingRepository bookingRepository;
   final UserRepository userRepository;
 public HotelServiceImpl(HotelRepository hotelRepository, RoomRepository roomRepository, BookingRepository bookingRepository, UserRepository userRepository){
     this.hotelRepository = hotelRepository;
     this.roomRepository = roomRepository;
     this.bookingRepository= bookingRepository;
     this.userRepository = userRepository;
    }
    @Override
    public HotelEntity AddHotel(HotelEntity hotel) {
    hotelRepository.save(hotel);
    return hotel;
    }

    @Override
    public RoomEntity AddRoom(RoomEntity room) {
        if(room.getBedsCount() < 0)
            throw new NotValidParametersException("The number of beds must be greater than or equal to zero");
       roomRepository.save(room);
       return room;
    }

    @Override
    public BookingEntity BookingRoom(BookingEntity bookingEntity) {
     Optional<BookingEntity[]> booking = bookingRepository.findAllByHotelIdAndRoomId(bookingEntity.getHotel().getId(), bookingEntity.getRoom().getId());
        long bookingBeg =bookingEntity.getStartDate().getTime();
        long bookingEnd = bookingEntity.getEndDate().getTime();
        if(bookingBeg >= bookingEnd)
         throw new NotValidParametersException("Not valid date");
     if(booking.isPresent()){

         long beg, end;
         for(var item : booking.get()){
             beg = item.getStartDate().getTime();
             end = item.getEndDate().getTime();
             if((beg >= bookingBeg && beg <=bookingEnd)|| ((end >= bookingBeg && end <=bookingEnd)))
                 throw new NotValidParametersException("Not valid date range");
         }
     }
     return bookingRepository.save(bookingEntity);
    }

    @Override
    public Boolean RemoveHotel(long id) {
        Optional<HotelEntity> hotelEntity = hotelRepository.findById(id);
        if(!hotelEntity.isPresent())
            return false;
        hotelRepository.delete(hotelEntity.get());
        return true;
    }

    @Override
    public Boolean RemoveRoom(long id) {
        Optional<RoomEntity> roomEntity = roomRepository.findById(id);
        if(!roomEntity.isPresent())
            return false;
        roomRepository.delete(roomEntity.get());
        return true;
    }

    @Override
    public BookingEntity[] getBookingByUserLogin(String login) {
    UserEntity userEntity = userRepository.findByLogin(login).orElseThrow(()->new UsernameNotFoundException("User not found!"));
    return bookingRepository.findAllByUserId(userEntity.getId()).orElseThrow(()-> new EmptyResult("Booking not found!"));
    }

}
