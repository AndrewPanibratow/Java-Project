package com.website.hotel.domain;

import javax.persistence.*;

@Entity
@Table(name = "Room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long hotelId;
    float price;
    @Column(name="Room_type")
    String roomType;
    @Column(name = "Beds_count")
    int bedsCount;
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


}
