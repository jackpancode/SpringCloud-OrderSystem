package com.besti.springcloud.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
@Data
public class Order {

    private long id;
    private User user;
    private Menu menu;
    private Admin admin;
    private Date date;
    private int state;
}
