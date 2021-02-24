package com.website.hotel.domain;

import javax.swing.*;

public class User {
    private int Id;
    private String Name;
    private String Surname;
    private String Email;
    private String Login;
    private String Password;
    public User(Integer Id, String Name, String Surname, String Email, String Login, String Password){
        this.Id = Id;
        this.Name = Name;
        this.Surname = Surname;
        this.Email = Email;
        this.Login =Login;
        this.Password = Password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
