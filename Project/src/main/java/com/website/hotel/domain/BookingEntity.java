package com.website.hotel.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long userId;
    long hotelId;
    long roomId;
    Date booking_date;
    int days;

    public BookingEntity(long id, long userId, long hotelId, long roomId, Date booking_date, int days) {
        this.id = id;
        this.userId = userId;
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.booking_date = booking_date;
        this.days = days;
    }

    public BookingEntity(){}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

}
