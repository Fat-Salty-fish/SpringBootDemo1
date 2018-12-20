package com.copy.demo.repository;

import com.copy.demo.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface OrderRepo extends CrudRepository<Order,Integer> {

    //根据单个订单id删除订单
    public Integer deleteById(int id);
    //根据多个订单id删除订单
    public Integer deleteAllByIdIn(Collection<Integer> ids);

}
