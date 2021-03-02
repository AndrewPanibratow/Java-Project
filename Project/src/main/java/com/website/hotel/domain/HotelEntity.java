package com.website.hotel.domain;

import javax.persistence.*;

@Entity
@Table(name = "Hotel")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    String Name;
    String Country;
    int Rooms_count;
    public HotelEntity(){}
    public HotelEntity(Long Id, String Name, String Country, int Rooms_count)
    {
        this.Id = Id;
        this.Name = Name;
        this.Country = Country;
        this.Rooms_count = Rooms_count;
    }
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getRooms_count() {
        return Rooms_count;
    }

    public void setRooms_count(int rooms_count) {
        Rooms_count = rooms_count;
    }
}
