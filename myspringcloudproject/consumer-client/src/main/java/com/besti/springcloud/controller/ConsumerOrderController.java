package com.besti.springcloud.controller;

import com.besti.springcloud.entity.Menu;
import com.besti.springcloud.entity.Order;
import com.besti.springcloud.entity.OrderVO;
import com.besti.springcloud.entity.User;
import com.besti.springcloud.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Parameter;

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
}
