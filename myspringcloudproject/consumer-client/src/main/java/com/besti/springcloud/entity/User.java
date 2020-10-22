package com.besti.springcloud.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
@Data
public class User {
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private Date registerdate;
    private String address;
}
