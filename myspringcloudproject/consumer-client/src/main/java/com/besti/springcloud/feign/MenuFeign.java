package com.besti.springcloud.feign;

import com.besti.springcloud.entity.Menu;
import com.besti.springcloud.entity.MenuVO;
import com.besti.springcloud.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Jack Pan
 * @version 1.0 2020/10/20
 */
@Component
@FeignClient(value = "menu")
public interface MenuFeign {


    @GetMapping(value = "/menu/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);

    @GetMapping(value = "/menu/findtypes")
    public List<Type> findTypes();

    @PostMapping(value = "/menu/save")
    public void save(Menu menu);

    @GetMapping(value = "/menu/findById/{id}")
    public Menu findById(@PathVariable("id") long id);

    @PutMapping(value = "/menu/update")
    public void update(Menu menu);
}
