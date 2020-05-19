package com.sj.repository;

import com.sj.entity.Admin;

public interface AdminRepository {
    public Admin login(String username,String password);
}
