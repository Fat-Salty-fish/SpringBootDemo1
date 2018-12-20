package com.copy.demo.contriller;

import com.copy.demo.model.Order;
import com.copy.demo.service.DetailService;
import com.copy.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Integer id)
    {
        System.out.println("正在获取order");
        return orderService.getOneOrder(id);
    }

    @PostMapping("")
    public Object createOrUpdate(@RequestBody Order order)
    {
        return orderService.saveOneOrder(order);
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable Integer id)
    {
        return orderService.deleteByOrderId(id);
    }

    @DeleteMapping("")
    public Object delete(@RequestBody Collection<Integer> ids)
    {
        return orderService.deleteByOrderIds(ids);
    }

}
