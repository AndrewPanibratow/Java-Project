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
    String room_type;
    int beds_count;
    public RoomEntity(long id,long hotelId, float price, String room_type, int beds_count) {
        this.id = id;
        this.hotelId = hotelId;
        this.price = price;
        this.room_type = room_type;
        this.beds_count = beds_count;
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

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public int getBeds_count() {
        return beds_count;
    }

    public void setBeds_count(int beds_count) {
        this.beds_count = beds_count;
    }


}
