package com.ksh.jasperdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private int id;
    private LocalDateTime date;
    private String name;
    private double weight;
    private String city;
}
