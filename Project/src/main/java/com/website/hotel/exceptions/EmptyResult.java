package com.website.hotel.exceptions;

public class EmptyResult extends RuntimeException{
    public EmptyResult(String message) {
        super(message);
    }
}
