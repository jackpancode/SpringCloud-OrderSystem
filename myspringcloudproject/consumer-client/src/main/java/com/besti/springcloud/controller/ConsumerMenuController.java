package com.besti.springcloud.controller;

import com.besti.springcloud.entity.Menu;
import com.besti.springcloud.entity.MenuVO;
import com.besti.springcloud.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/20
 */
@Controller//默认返回视图  ；RestController默认返回数据
@RequestMapping("/consumermenu")
public class ConsumerMenuController {

    @Resource
    private MenuFeign menuFeign;

    @GetMapping(value = "/findAll")
    @ResponseBody  //返回数据而不是视图
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index =  (page-1)*limit;
        MenuVO menuVO = menuFeign.findAll(index,limit);
        return menuVO;
    }

    @GetMapping(value = "/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping(value = "/deleteById/{id}")    //layui模板前端发送来的删除数据请求为GET，所以此处必须使用GET请求
    public String deleteById(@PathVariable("id") long id){
        menuFeign.deleteById(id);
        return "redirect:/consumermenu/redirect/menu_manage";  //删除完成后刷新页面
    }

    @GetMapping(value = "/findtypes")
    public ModelAndView findTypes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_add");//跳转到menu_add.html
        modelAndView.addObject("list",menuFeign.findTypes());// list是所有type（菜品类型)的集合
        return  modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "redirect:/consumermenu/redirect/menu_manage"; //添加完成后刷新页面
    }

    @GetMapping(value = "/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_update");   //跳转到修改页面
        modelAndView.addObject("menu",menuFeign.findById(id));
        modelAndView.addObject("list",menuFeign.findTypes());// list是所有type（菜品类型)的集合
        return modelAndView;

    }

    @PostMapping(value = "/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/consumermenu/redirect/menu_manage"; //修改完成后刷新页面
    }
}
