package com.besti.springcloud.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/24
 */
@Data
public class OrderHandler {

    private long id;
    private String name;
    private double price;
    private String flavor;
    private String nickname;
    private String telephone;
    private String address;
    private Date date;
}
