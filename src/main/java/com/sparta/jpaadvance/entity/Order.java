package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class) //EntityListeners는 Jpa 엔티티에서 이벤트가 발생할 때마다 콜백을 처리할 수 있게 해 준다. 엔티티의 변화를 감지하여 엔티티와 매핑된 테이블의 데이터를 조작! 이 어노테이션의 파라미터에 이벤트 리스너를 넣어줘야하는데, 여기에 AuditingEntityListener 클래스를 넣어준다. 이 클래스는 Spring Data JPA에서 제공하는 이벤트 리스너로 엔티티의 영속, 수정 이벤트를 감지하는 역할을 한다.
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP) //Temporal일시적인 TemporalType.TIMESTAMP : date + time 의 timestamp(datetime) 타입(Temporal에노테이션 사용하지 않을 경우 기본값은 timestamp)

    private LocalDateTime orderDate;
}