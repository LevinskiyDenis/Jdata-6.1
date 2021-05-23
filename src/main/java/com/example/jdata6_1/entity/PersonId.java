package com.example.jdata6_1.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonId implements Serializable {

    private String name;
    private String surname;
    private int age;

}
