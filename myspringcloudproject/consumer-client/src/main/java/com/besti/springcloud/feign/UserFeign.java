package com.besti.springcloud.feign;
import com.besti.springcloud.entity.User;
import com.besti.springcloud.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
@Component
@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping(value = "/user/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @GetMapping(value = "/user/count")
    public int count();

    @PostMapping(value = "/user/save")
    public void save(User user);


    @DeleteMapping(value = "/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);
}
