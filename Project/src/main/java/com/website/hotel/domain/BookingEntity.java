package com.website.hotel.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    long UserId;
    long HotelId;
    long RoomId;
    Date Booking_date;
    int Days;

    public BookingEntity(){}
    public BookingEntity(long id, long userId, long hotelId, long roomId, Date booking_date, int days) {
        Id = id;
        UserId = userId;
        HotelId = hotelId;
        RoomId = roomId;
        Booking_date = booking_date;
        Days = days;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public long getHotelId() {
        return HotelId;
    }

    public void setHotelId(long hotelId) {
        HotelId = hotelId;
    }

    public long getRoomId() {
        return RoomId;
    }

    public void setRoomId(long roomId) {
        RoomId = roomId;
    }

    public Date getBooking_date() {
        return Booking_date;
    }

    public void setBooking_date(Date booking_date) {
        Booking_date = booking_date;
    }

    public int getDays() {
        return Days;
    }

    public void setDays(int days) {
        Days = days;
    }

}
