package com.besti.springcloud.repository;

import com.besti.springcloud.entity.User;

import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
public interface UserRepository {

    public List<User> findAll(int index,int limit);

    public User findById(long id);

    public int count();

    public void save(User user);

    public void update(User user);

    public void deleteById(long id);

}
