package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//jpa서 직접 만드는 중간테이블을 우리가 다루기 까다롭다면, 직접 만들면 되잖아! 해서 만든 것.
@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id") // 하나의 음식은 여러번 주문 될 수 있다. 오더테이블이니까 오더 먼저라 ManyToOne
    private Food food; //List아님

    @ManyToOne
    @JoinColumn(name = "user_id") // 한명이 여러번 주문할 수 있다. 오더테이블이니까 ManyToOne
    private User user; //List아님
}