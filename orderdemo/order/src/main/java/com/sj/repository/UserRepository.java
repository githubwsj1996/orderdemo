package com.sj.repository;

import com.sj.entity.User;

import java.util.List;

public interface UserRepository {
    public User findById(Integer id);

}
