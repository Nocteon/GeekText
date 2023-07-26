package com.geektext.app.rest.Models;

import jakarta.persistence.*;

@Entity
public class User{

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String userName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



}
