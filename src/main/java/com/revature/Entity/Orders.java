package com.revature.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private long orderID;
    private long userId;
    private String status;

    public Orders(long userId, String status){
        this.userId = userId;
        this.status = status;
    }
}
