package com.sj.feign;


import com.sj.entity.Menu;
import com.sj.entity.MenuVO;
import com.sj.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id);

    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();

    @PostMapping("/menu/save")
    public void save(@RequestBody Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") Integer id);

    @PutMapping("/menu/update")
    public void update(@RequestBody Menu menu);
}
