package com.sj.controller;

import com.sj.entity.Order;
import com.sj.entity.OrderVO;
import com.sj.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
public class OrderHandler {

   @Autowired
   private OrderRepository orderRepository;

   @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
   public OrderVO findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit,@PathVariable("uid") int uid)
   {
       return new OrderVO(0,"",orderRepository.countByUid(uid),orderRepository.findAllByUid(index,limit,uid));
   }

   @PostMapping("/save")
    public void save(@RequestBody Order order)
   {
       orderRepository.save(order);
   }

   @GetMapping("/findAll/{index}/{limit}")
   public OrderVO findAll(@PathVariable("index") int index,@PathVariable("limit") int limit)
   {
       return  new OrderVO(0,"",orderRepository.countByStateId(),orderRepository.findAll(index,limit));
   }

   @PutMapping("/updateState/{id}")
   public void updateState(@PathVariable("id") Integer id)
   {
       orderRepository.updateState(id);
   }
}
