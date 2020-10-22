package com.besti.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {

    private int code;
    private String msg;
    private int count;
    private List<Order> data;
}
