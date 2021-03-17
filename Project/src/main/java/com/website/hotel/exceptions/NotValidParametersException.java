package com.website.hotel.exceptions;

public class NotValidParametersException extends RuntimeException
{
    public NotValidParametersException(String Message){
        super(Message);
    }
}
