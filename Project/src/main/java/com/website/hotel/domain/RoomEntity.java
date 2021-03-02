package com.website.hotel.domain;

import javax.persistence.*;

@Entity
@Table(name = "Room")
public class RoomEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    float price;
    String Room_type;
    int Beds_count;

    public RoomEntity(long id, float price, String room_type, int beds_count) {
        Id = id;
        this.price = price;
        Room_type = room_type;
        Beds_count = beds_count;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getRoom_type() {
        return Room_type;
    }

    public void setRoom_type(String room_type) {
        Room_type = room_type;
    }

    public int getBeds_count() {
        return Beds_count;
    }

    public void setBeds_count(int beds_count) {
        Beds_count = beds_count;
    }

}
