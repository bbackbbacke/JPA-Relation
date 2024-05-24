package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy = GenerationType.IDENTITY = 기본키 생성 전략
    private Long id;
    private String name;
    private double price;

    @OneToMany(mappedBy = "food") // 하나의 음식은 여러번 주문될 수 있다 -> OneToMany
    private List<Order> orderList = new ArrayList<>(); //뒤쪽(상대 엔티티Order)이 Many니까 List형식인것!
}