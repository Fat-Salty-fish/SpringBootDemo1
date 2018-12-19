package com.copy.demo.repository;

import com.copy.demo.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<Orders,Integer> {

    //根据订单id删除订单
    public void  deleteById(int id);

    //当修改某个货物详情时(删除某个货物时) 对订单的修改


}
