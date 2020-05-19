package com.sj.repository;

import com.sj.entity.Order;

import java.util.List;

public interface OrderRepository {
    public List<Order> findAllByUid(int index, int limit, int uid);
    public void save(Order order);
    public int countByUid(int uid);

    public List<Order> findAll(int index,int limit);
    public void updateState(Integer id);
    public int countByStateId();
}

