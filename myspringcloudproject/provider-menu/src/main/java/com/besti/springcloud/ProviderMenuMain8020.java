package com.besti.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/20
 */

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.besti.springcloud.repository")
public class ProviderMenuMain8020 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderMenuMain8020.class,args);
    }
}
