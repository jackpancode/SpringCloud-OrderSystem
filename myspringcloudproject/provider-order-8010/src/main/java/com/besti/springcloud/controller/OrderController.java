package com.besti.springcloud.controller;

import com.besti.springcloud.entity.Order;
import com.besti.springcloud.entity.OrderVO;
import com.besti.springcloud.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * @author Jack Pan
 * @version 1.0 2020/10/19
 */

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(value = "/save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        orderRepository.save(order);
    }

    @GetMapping(value = "/findAllByUid/{index}/{limit}/{uid}",produces = {"application/json;charset=UTF-8"})
    public OrderVO findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid){
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByUid(uid));
        orderVO.setData(orderRepository.findAllByUid(index,limit,uid));
        return orderVO;
    }

    @GetMapping(value = "/countByUid/{uid}",produces = {"application/json;charset=UTF-8"})
    public int countByUid(@PathVariable("uid") int uid){
        return orderRepository.countByUid(uid);
    }
}
