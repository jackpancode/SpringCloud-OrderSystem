package com.besti.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/20
 */
@SpringBootApplication
@EnableFeignClients
@ServletComponentScan
@EnableDiscoveryClient
public class ConsumerClientMain8030 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerClientMain8030.class,args);
    }
}
