package com.besti.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */

@SpringBootApplication
@MapperScan("com.besti.springcloud.repository")
@EnableDiscoveryClient
public class ProviderUserMain8040 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderUserMain8040.class,args);
    }
}
