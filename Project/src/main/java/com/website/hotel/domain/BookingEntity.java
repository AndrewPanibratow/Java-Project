package com.website.hotel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name="UserId")
    long userId;
    @Column(name="HotelId")
    long hotelId;
    @Column(name="RoomId")
    long roomId;
    @Column(name="StartDate")
    @JsonFormat(pattern="dd.MM.yyyy")
    Date startDate;
    @Column(name="EndDate")
    @JsonFormat(pattern="dd.MM.yyyy")
    Date endDate;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    UserEntity user;
    @ManyToOne()
    @JoinColumn(name = "hotel_id")
    HotelEntity hotel;
    @ManyToOne()
    @JoinColumn(name = "room_id")
    RoomEntity room;

    public BookingEntity(long id, long userId, long hotelId, long roomId, Date startDate, Calendar endDate) {
        this.id = id;
        this.userId = userId;
        this.hotelId = hotelId;
        this.roomId = roomId;
        startDate = startDate;
        endDate = endDate;
    }

    public BookingEntity(){ }

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
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public RoomEntity getRoom() {
        return room;
    }
}
