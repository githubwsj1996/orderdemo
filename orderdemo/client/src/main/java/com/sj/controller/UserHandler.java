package com.sj.controller;

import com.sj.entity.User;
import com.sj.entity.UserVO;
import com.sj.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit)
    {
        int index=(page-1)*limit;
        return userFeign.findAll(index,limit);
    }

    @PostMapping("/save")
    public String save(User user)
    {
        userFeign.save(user);
        user.setRegisterdate(new Date());
        return  "redirect:/menu/redirect/user_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id)
    {
        userFeign.deleteById(id);
        return  "redirect:/menu/redirect/user_manage";
    }

    @GetMapping("/count")
    public int count(){return userFeign.count();}

}
