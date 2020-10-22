package com.besti.springcloud.controller;

import com.besti.springcloud.entity.Admin;
import com.besti.springcloud.entity.User;
import com.besti.springcloud.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
@Controller  //解析视图模式，而不是返回数据
@RequestMapping(value = "/consumeraccount")
public class ConsumerAccountController {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Object object = accountFeign.login(username,password,type);
        LinkedHashMap<String,Object> hashMap = (LinkedHashMap) object;
        String result = null;
        String idStr = null;
        long id = 0;
       if(object == null){
            result = "login";
        }else{
           switch (type){
               case "user":
                   User user = new User();
                   idStr = hashMap.get("id")+"";
                   id = Long.parseLong(idStr);
                   String nickname = (String)hashMap.get("nickname");
                   user.setId(id);
                   user.setNickname(nickname);

                   session.setAttribute("user",user);
                   result = "index";
                   break;
               case "admin":
                   Admin admin = new Admin();
                   idStr = hashMap.get("id")+"";
                   id = Long.parseLong(idStr);
                   String username2 = (String)hashMap.get("username");
                   admin.setId(id);
                   admin.setUsername(username2);
                   session.setAttribute("admin",admin);
                   result = "main";
                   break;
           }
       }
        return result;
    }


    @GetMapping(value = "/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate(); //销毁session，实现登出功能
        return "redirect:/login.html"; //重定向到登录页面
    }
}
