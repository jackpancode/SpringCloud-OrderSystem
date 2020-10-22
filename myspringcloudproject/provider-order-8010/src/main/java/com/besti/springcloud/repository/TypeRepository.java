package com.besti.springcloud.repository;

import com.besti.springcloud.entity.Type;

import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/20
 */
public interface TypeRepository {

    public Type findById(long id);
    public List<Type> findAll();
}
