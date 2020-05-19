package com.sj.feign;

import com.sj.entity.User;
import com.sj.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping("/user/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable("index") Integer index, @PathVariable("limit") Integer limit);

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") Integer id);

    @GetMapping("/user/count")
    public int count();

    @PostMapping("/user/save")
    public void save(@RequestBody User user);

    @PutMapping("/user/update")
    public void update(@RequestBody User user);

    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id);

}
