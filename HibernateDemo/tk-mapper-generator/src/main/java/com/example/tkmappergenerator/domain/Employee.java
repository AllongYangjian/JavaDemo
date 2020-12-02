package com.example.tkmappergenerator.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer age;

    private String email;

    @Column(name = "last_name")
    private String lastName;


}