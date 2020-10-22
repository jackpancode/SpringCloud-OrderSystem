package com.besti.springcloud.controller;

import com.besti.springcloud.entity.Menu;
import com.besti.springcloud.entity.MenuVO;
import com.besti.springcloud.entity.Type;
import com.besti.springcloud.repository.MenuRepository;
import com.besti.springcloud.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/20
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/port")
    public String index(){
        return this.serverPort;
    }

    @GetMapping(value = "/findAll/{index}/{limit}",produces = { "application/json;charset=UTF-8" })
    //添加produces = { "application/json;charset=UTF-8" }返回json格式数据
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){

        List<Menu> list = menuRepository.findAll(index,limit);
        return  new MenuVO(0,"",menuRepository.count(),list);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuRepository.deleteById(id);
    }

    @GetMapping(value = "/findtypes",produces ={"application/json;charset=UTF-8"})
    public List<Type> findTypes(){
        return  typeRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){   //添加RequestBody将消费者发来的json数据转为menu对象
        menuRepository.save(menu);
    }

    @GetMapping(value = "/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuRepository.findById(id);
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody Menu menu){
        menuRepository.update(menu);
    }
}
