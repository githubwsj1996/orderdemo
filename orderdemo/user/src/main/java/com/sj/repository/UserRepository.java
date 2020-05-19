package com.sj.repository;

import com.sj.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll(int index,int limit);
    public User findById(Integer id);
    public int count();
    public void save(User user);
    public void update(User user);
    public void deleteById(Integer id);
}
