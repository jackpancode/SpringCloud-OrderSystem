package com.besti.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/20
 */

//封装json数据格式，符合layui接收json数据格式要求
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {

    private int code;
    private String msg;
    private int count;
    private List<Menu> data;
}
