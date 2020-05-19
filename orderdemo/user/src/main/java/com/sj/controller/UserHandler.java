package com.sj.controller;

import com.sj.entity.User;
import com.sj.entity.UserVO;
import com.sj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable("index") Integer index, @PathVariable("limit") Integer limit)
    {
        return new UserVO(0,"",userRepository.count(),userRepository.findAll(index,limit));
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id)
    {
        return userRepository.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user)
    {
        userRepository.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id)
    {
        userRepository.deleteById(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user)
    {
        userRepository.update(user);
    }

    @GetMapping("/count")
    public int count()
    {
        return userRepository.count();
    }
}
