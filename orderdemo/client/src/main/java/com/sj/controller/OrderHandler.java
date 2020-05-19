package com.sj.controller;

import com.sj.entity.Menu;
import com.sj.entity.Order;
import com.sj.entity.OrderVO;
import com.sj.entity.User;
import com.sj.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") int mid, HttpSession session)
    {
        User user=(User) session.getAttribute("user");
        Menu menu=new Menu();
        menu.setId(mid);
        Order order=new Order();
        order.setUser(user);
        order.setMenu(menu);
        order.setDate(new Date());
        orderFeign.save(order);
        return "redirect:/menu/redirect/order";
    }

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVO findAllByUid(@RequestParam("page") int page,@RequestParam("limit") int limit,HttpSession session)
    {
        int index=(page-1)*limit;
        User user=(User)session.getAttribute("user");
        return orderFeign.findAllByUid(index,limit,user.getId());
    }

    @GetMapping("/findAll")
    @ResponseBody
    public OrderVO findAll(@RequestParam("page") int page,@RequestParam("limit") int limit)
    {
        int index=(page-1)*limit;
        return orderFeign.findAll(index,limit);
    }

    @GetMapping("/updateState/{id}")
    public String update(@PathVariable("id") Integer id)
    {
        orderFeign.updateState(id);

        return "redirect:/menu/redirect/order_handler";
    }

}
