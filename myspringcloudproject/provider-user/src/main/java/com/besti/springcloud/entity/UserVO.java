package com.besti.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private int code;
    private String msg;
    private int count;
    private List<User> data;
}
