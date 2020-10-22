package com.besti.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
@SpringBootApplication
@MapperScan(value = "com.besti.springcloud.repository")
public class ProviderAccountMain8050 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderAccountMain8050.class,args);
    }
}
