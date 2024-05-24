package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user") // 한명이 여러번 주문할 수 있다. OneToMany
    private List<Order> orderList = new ArrayList<>(); //뒤쪽(상대 엔티티Order)이 Many니까 List형식인것!
}