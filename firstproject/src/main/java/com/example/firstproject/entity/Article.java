package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity // DB가 해당 객체를 엔티티로 인식 가능(해당 클래스로 테이블 생성)
@AllArgsConstructor
@NoArgsConstructor // default constructor
@ToString
@Getter
public class Article {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatic generation annotation by DB
//    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String content;
}
