package com.website.hotel.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name ="HotelId")
    long hotelId;
    float price;
    @Column(name="RoomType")
    String roomType;
    @Column(name = "BedsCount")
    int bedsCount;

    @ManyToOne()
    @JoinColumn(name = "hotel_id")
    HotelEntity hotelEntity;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "booking_RoomId")
    List<BookingEntity> booking;
    public RoomEntity(long id,long hotelId, float price, String roomType, int bedsCount) {
        this.id = id;
        this.hotelId = hotelId;
        this.price = price;
        this.roomType = roomType;
        this.bedsCount = bedsCount;
    }

    public RoomEntity(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String room_type) {
        this.roomType = room_type;
    }

    public int getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(int beds_count) {
        this.bedsCount = beds_count;
    }

    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }

    public List<BookingEntity> getBooking() {
        return booking;
    }


}
