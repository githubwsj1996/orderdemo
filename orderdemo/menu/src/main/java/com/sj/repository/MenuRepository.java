package com.sj.repository;

import com.sj.entity.Menu;

import java.util.List;

public interface MenuRepository {
    public List<Menu> findAll(int index,int limit);
    public int count();
    public Menu findById(Integer id);
    public void save(Menu menu);
    public void update(Menu menu);
    public void deleteById(Integer id);
}
