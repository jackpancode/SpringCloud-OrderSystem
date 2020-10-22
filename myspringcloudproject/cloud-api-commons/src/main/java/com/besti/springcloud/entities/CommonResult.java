package com.besti.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //实现set和get方法
@AllArgsConstructor  //实现全参构造器
@NoArgsConstructor  //实现空参构造器
public class CommonResult <T>
{

    //404 not_found
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message)
    {
        this(code,message,null);
    }
}
