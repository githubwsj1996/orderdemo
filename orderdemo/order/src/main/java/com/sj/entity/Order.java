package com.sj.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Integer id;
    private User user;
    private Menu menu;
    private Admin admin;
    private Date date;
    private Integer state;
}
