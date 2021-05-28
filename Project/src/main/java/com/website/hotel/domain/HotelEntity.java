package com.website.hotel.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "Hotel")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotBlank(message = "Name is required!")
    @NotNull()
    String name;
    @NotBlank(message = "Country name is required!")
    @NotNull()
    String country;
    @NotBlank(message = "Address is required!")
    @NotNull()
    String address;

    public HotelEntity(long id, String name, String country, int rooms_count, String address) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
    }


    public HotelEntity(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
