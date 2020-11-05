package com.besti.springcloud.repository;

import com.besti.springcloud.entity.Menu;

import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/20
 */
public interface MenuRepository {

    public Menu findById(long id);
}
