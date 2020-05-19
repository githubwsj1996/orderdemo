package com.sj.repository;

import com.sj.entity.User;

public interface UserRepository {
    public User login(String username,String password);
}
