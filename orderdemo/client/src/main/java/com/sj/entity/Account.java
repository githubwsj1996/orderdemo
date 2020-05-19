package com.sj.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Account {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private Date registerdate;
    private String address;
}
