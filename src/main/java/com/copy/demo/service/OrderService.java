package com.copy.demo.service;


import com.copy.demo.model.Detail;
import com.copy.demo.model.Order;
import com.copy.demo.repository.DetailRepo;
import com.copy.demo.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service

public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private DetailRepo detailRepo;

    //保存order订单
    @Transactional
    public Order getOneOrder(Integer id)
    {
        Order order = orderRepo.findOne(id);
        if(order==null)
        {
            return null;
        }
        List<Detail> details = detailRepo.getDetailsByOrdersId(id);

        order.setDetails(details);

        return order;
    }

    @Transactional
    public String saveOneOrder(Order order)
    {
        orderRepo.save(order);
        return "成功保存order信息";
    }

    //根据orderID删除单个order信息
    @Transactional
    public String deleteByOrderId(Integer id)
    {
        Integer deleteDetailsRow = detailRepo.deleteAllByOrdersId(id);//先删除明细
        Integer deleteOrderRow = orderRepo.deleteById(id);           //再删除订单
        return "成功删除orders表"+deleteOrderRow+"条以及details表中数据"+deleteDetailsRow+"条";
    }
    //根据Collection<ID>删除多个order信息
    @Transactional
    public String deleteByOrderIds(Collection<Integer> ids)
    {
        Integer deleteOrdersRows = detailRepo.deleteAllByOrdersIdIn(ids);
        Integer deleteDetailsRows = orderRepo.deleteAllByIdIn(ids);
        return "成功删除orders表数据"+deleteOrdersRows+"条 成功删除details表数据"+deleteDetailsRows+"条";
    }

}
