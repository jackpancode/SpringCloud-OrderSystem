package com.besti.springcloud.repository;

import com.besti.springcloud.entity.Menu;

import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/20
 */
public interface MenuRepository {

    public List<Menu> findAll(int index,int limit);
    public int count();
    public Menu findById(long id);
    public void save(Menu menu);
    public void update(Menu menu);
    public void deleteById(long id);

}
