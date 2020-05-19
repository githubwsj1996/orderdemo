package com.sj.feign;

import com.sj.entity.Order;
import com.sj.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save(@RequestBody Order order);

    @GetMapping("/order/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAllByUid(@PathVariable("index") int index,@PathVariable("limit") int limit,@PathVariable("uid") int uid);

    @GetMapping("/order/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable("index")int index,@PathVariable("limit")int limit);

    @PutMapping("/order/updateState/{id}")
    public void updateState(@PathVariable("id") Integer id);
}
