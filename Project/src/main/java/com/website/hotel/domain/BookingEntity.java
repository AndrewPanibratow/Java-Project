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

    @Column(name="StartDate")
    @JsonFormat(pattern="dd.MM.yyyy")
    Date startDate;

    @Column(name="EndDate")
    @JsonFormat(pattern="dd.MM.yyyy")
    Date endDate;

    @ManyToOne
    @JoinColumn(name="UserId", referencedColumnName = "Id")
    UserEntity user;
    @ManyToOne
    @JoinColumn(name="HotelId")
    HotelEntity hotel;
    @ManyToOne
    @JoinColumn(name="RoomId")
    RoomEntity room;

    public BookingEntity(long id, Date startDate, Calendar endDate) {
        this.id = id;
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

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

}
