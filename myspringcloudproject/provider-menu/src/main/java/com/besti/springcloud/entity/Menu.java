package com.besti.springcloud.entity;

import lombok.Data;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/20
 */
@Data
public class Menu {

    private long id;
    private String name;
    private double price;
    private String flavor;
    private Type type;
}
