package com.besti.springcloud.controller;

import com.besti.springcloud.entity.User;
import com.besti.springcloud.entity.UserVO;
import com.besti.springcloud.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
@Controller
@RequestMapping("/consumeruser")
public class ConsumerUserController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping(value = "/findAll")
    @ResponseBody   //返回数据而不是视图
    public UserVO findAll(@RequestParam("page") int page , @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        UserVO userVO = userFeign.findAll(index,limit);
        return userVO;
    }

    @GetMapping(value = "/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }


    @GetMapping(value = "/count")
    public int count(){
        return userFeign.count();
    }

    @PostMapping(value = "/save")
    public String save(User user){//当用postman测试时，由于传入的是json数据，需要加@RequestBody，正式用网页form表单提交数据不用加
        user.setRegisterdate(new Date()); //获取系统时间，添加到user对象
        userFeign.save(user);
        return  "redirect:/consumeruser/redirect/user_manage";
    }


    @GetMapping(value = "/deleteById/{id}")    //layui模板前端发送来的删除数据请求为GET，所以此处必须使用GET请求
    public String deleteById(@PathVariable("id") long id){
        userFeign.deleteById(id);
        return  "redirect:/consumeruser/redirect/user_manage";
    }
}
