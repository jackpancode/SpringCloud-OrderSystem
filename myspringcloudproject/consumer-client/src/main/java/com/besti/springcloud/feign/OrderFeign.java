package com.besti.springcloud.feign;

import com.besti.springcloud.entity.Order;
import com.besti.springcloud.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/22
 */
@Component
@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping(value = "/order/save")
    public void save(@RequestBody Order order);

    @GetMapping(value = "/order/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid);
}
