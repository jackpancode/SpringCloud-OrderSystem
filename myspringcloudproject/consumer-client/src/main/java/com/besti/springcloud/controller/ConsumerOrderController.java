package com.besti.springcloud.controller;

import com.besti.springcloud.entity.*;
import com.besti.springcloud.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/22
 */

@Controller
@RequestMapping(value = "/consumerorder")
public class ConsumerOrderController {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping(value = "/save/{mid}")
    public String save(@PathVariable("mid") int mid,HttpSession session){
        User user = (User)session.getAttribute("user");
        Order order = new Order();
        order.setUser(user);
        Menu menu = new Menu();
        menu.setId(mid);
        order.setMenu(menu);
        orderFeign.save(order);
        return  "order";

    }

    @GetMapping(value = "/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }


    @GetMapping(value = "/findAllByUid")
    @ResponseBody  //返回数据而不是视图
    public OrderVO findAllByUid(@RequestParam("page") int page,@RequestParam("limit") int limit, HttpSession session){
        User user = (User)session.getAttribute("user");
        int index = (page-1)*limit;
        return orderFeign.findAllByUid(index,limit,user.getId());
    }

    @GetMapping(value = "/findAllByState")
    @ResponseBody  //返回数据而不是视图
    public OrderVO findAllByState(@RequestParam("page") int page,@RequestParam("limit") int limit){
        int index = (page-1)*limit;
        OrderVO orderVO = new OrderVO();
        orderVO  = orderFeign.findAllByState(index,limit);
        return  orderVO;
    }

//    @GetMapping(value = "/findAllByState")
//    @ResponseBody  //返回数据而不是视图
//    public OrderHandlerVO findAllByState(@RequestParam("page") int page,@RequestParam("limit") int limit){
//        int index = (page-1)*limit;
//        OrderVO orderVO = new OrderVO();
//        OrderHandlerVO orderHandlerVO = new OrderHandlerVO();
//        orderVO  = orderFeign.findAllByState(index,limit);
//        OrderHandler orderHandler = new OrderHandler();
//     //   List<Order2> data= orderHandler.getOrderMsg(orderVO);
//        orderHandlerVO = orderHandler.hander(orderHandler.getOrderMsg(orderVO));
//        return  orderHandlerVO;
//    }


    @GetMapping(value = "/updateState/{id}")
    public String updateState(@PathVariable("id") long id){
        orderFeign.updateState(id);
        return "redirect:/consumerorder/redirect/order_handler";
    }
}
