package com.website.hotel.services;

import com.website.hotel.domain.BookingEntity;
import com.website.hotel.domain.HotelEntity;
import com.website.hotel.domain.RoomEntity;
import com.website.hotel.exceptions.NotValidParametersException;
import com.website.hotel.repositories.BookingRepository;
import com.website.hotel.repositories.HotelRepository;
import com.website.hotel.repositories.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

@Service
@Transactional
public class HotelServiceImpl implements  HotelService {
   final HotelRepository hotelRepository;
   final RoomRepository roomRepository;
   final BookingRepository bookingRepository;
 public HotelServiceImpl(HotelRepository hotelRepository, RoomRepository roomRepository, BookingRepository bookingRepository){
     this.hotelRepository = hotelRepository;
     this.roomRepository = roomRepository;
     this.bookingRepository= bookingRepository;
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
     Optional<BookingEntity[]> booking = bookingRepository.findAllByHotelIdAndRoomId(bookingEntity.getHotelId(), bookingEntity.getRoomId());
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
}
