package com.besti.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/19
 */

@SpringBootApplication
@EnableConfigServer
public class ConfigMain8762 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain8762.class,args);
    }
}
