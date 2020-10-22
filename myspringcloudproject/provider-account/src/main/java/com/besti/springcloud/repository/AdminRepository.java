package com.besti.springcloud.repository;

import com.besti.springcloud.entity.Admin;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
public interface AdminRepository {

    public Admin login(String username, String password);
}
