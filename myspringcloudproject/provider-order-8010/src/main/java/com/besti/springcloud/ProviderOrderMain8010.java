package com.besti.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/19
 */

@SpringBootApplication
@MapperScan(value = "com.besti.springcloud.repository")
public class ProviderOrderMain8010 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderOrderMain8010.class,args);
    }
}
