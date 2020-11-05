package com.besti.springcloud.feign;

import com.besti.springcloud.entity.Order;
import com.besti.springcloud.entity.OrderHandler;
import com.besti.springcloud.entity.OrderHandlerVO;
import com.besti.springcloud.entity.OrderVO;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/22
 */
@Component
@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping(value = "/order/save")
    public void save(@RequestBody Order order);

//    根据用户id查询订单信息消费端接口
    @GetMapping(value = "/order/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid);

    //管理员查询未派送订单信息消费端接口
    @GetMapping(value = "/order/findAllByState/{index}/{limit}")
    public OrderVO findAllByState(@PathVariable("index") int index,@PathVariable("limit") int limit);


    @PutMapping(value = "/order/updateState/{id}")
    public void updateState(@PathVariable("id") long id);

}
