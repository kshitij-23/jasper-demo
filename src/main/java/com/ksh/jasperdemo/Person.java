package com.ksh.jasperdemo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Person {

    private int id;
    private String name;
    private String email;
    private long mobile;
    private LocalDate birthDate;
}
