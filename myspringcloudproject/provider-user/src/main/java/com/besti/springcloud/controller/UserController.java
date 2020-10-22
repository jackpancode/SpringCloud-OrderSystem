package com.besti.springcloud.controller;

import com.besti.springcloud.entity.User;
import com.besti.springcloud.entity.UserVO;
import com.besti.springcloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping(value = "/findAll/{index}/{limit}",produces = { "application/json;charset=UTF-8" })
    //添加produces = { "application/json;charset=UTF-8" }返回json格式数据
    public UserVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){

        List<User> list = userRepository.findAll(index,limit);
        return  new UserVO(0,"",userRepository.count(),list);
    }

    @GetMapping(value = "/findById/{id}")
    public User findById(@PathVariable("id") long id){
        return userRepository.findById(id);
    }

    @GetMapping(value = "/count")
    public int count(){
        return userRepository.count();
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody User user){     //对前端发送来的user对象json数据进行封装成User对象才可进行SQL操作
        userRepository.save(user);
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody User user){  ///同上
        userRepository.update(user);
    }


    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
    }

}
