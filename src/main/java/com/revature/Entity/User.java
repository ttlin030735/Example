package com.revature.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long userId;
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    private String address;
    private String state;
    private String city;
    private String zip;
    @Column(nullable = false, unique = true)
    private String phone;

    public User(String name, String email, String address, String city, String state, String zip, String phone, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.password = password;
    }
}
