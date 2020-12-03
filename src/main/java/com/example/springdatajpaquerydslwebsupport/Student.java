package com.example.springdatajpaquerydslwebsupport;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String major;

    public Student(String name, String major) {
        this.name = name;
        this.major = major;
    }
}
