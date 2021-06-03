package com.website.hotel.domain;

import javax.persistence.*;

@Entity
@Table(name = "Room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    float price;
    @Column(name="RoomType")
    String roomType;
    @Column(name = "BedsCount")
    int bedsCount;

    @ManyToOne
    @JoinColumn(name="HotelId")
    HotelEntity hotel;

    public RoomEntity(long id, float price, String roomType, int bedsCount) {
        this.id = id;
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

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }
}
