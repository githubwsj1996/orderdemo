package com.sj.controller;

import com.sj.entity.Account;
import com.sj.entity.Admin;
import com.sj.entity.User;
import com.sj.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session)
    {
        Account account=accountFeign.login(username,password,type);
        String result=null;
        if(account==null)
        {
            result="redirect:login.html";
        } else {
            switch (type) {
                case "user":
                    User user=new User();
                    user.setId(account.getId());
                    user.setNickname(account.getNickname());
                    session.setAttribute("user",user);
                    result="redirect:/menu/redirect/index";
                    break;
                case "admin":
                    Admin admin=new Admin();
                    admin.setId(account.getId());
                    admin.setUsername(account.getUsername());
                    session.setAttribute("admin",admin);
                    result="redirect:/menu/redirect/main";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/login.html";
    }
}
