package com.besti.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
@FeignClient(value = "account")
public interface AccountFeign {

    @GetMapping(value = "/account/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("type") String type);
}
