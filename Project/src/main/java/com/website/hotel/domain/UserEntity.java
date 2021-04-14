package com.website.hotel.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required!")
    @NotNull()
    private String name;
    @NotBlank(message = "Surname is required!")
    @NotNull()
    private String surname;
    @Pattern(regexp = "^\\w+@[A-BZa-z]+\\.[a-z]{0,4}$", message = "Not valid email!")
    private String email;
    @NotBlank(message = "Login is required!")
    @NotNull()
    private String login;
    @Size(min = 5, message = "Password must have at least 5 symbols!")
    @NotNull()
    private String password;
    public UserEntity(Long id, String name, String surname, String email, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.password = password;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserEntity(){

    }



}
