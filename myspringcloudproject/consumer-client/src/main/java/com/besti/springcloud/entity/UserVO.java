package com.besti.springcloud.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
@Data
public class UserVO {

    private int code;
    private String msg;
    private int count;
    private List<User> data;
}
