package com.besti.springcloud.repository;

import com.besti.springcloud.entity.User;

import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
public interface UserRepository {


    public User findById(long id);

}
