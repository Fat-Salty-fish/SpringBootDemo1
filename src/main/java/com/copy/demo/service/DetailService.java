package com.copy.demo.service;


import com.copy.demo.model.Detail;
import com.copy.demo.model.Order;
import com.copy.demo.repository.DetailRepo;
import com.copy.demo.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
public class DetailService {

    @Autowired
    private DetailRepo detailRepo;
    @Autowired
    private OrderRepo orderRepo;

    @Transactional
    public Detail getOneById(Integer id)
    {
        return detailRepo.findOneById(id);
    }

    @Transactional
    public String saveOneDetail(Detail detail)
    {
        detailRepo.save(detail);
        Order new_order = this.updateOrSaveOrder(detail.getOrdersId());
        detail.setOrdersId(new_order.getId());
        detailRepo.save(detail);
        return "成功保存detail信息";
    }

    @Transactional
    public String deleteById(Integer id)
    {
        //先查找orderId 以便后面进行order表的更新
        Integer orderId = detailRepo.findOneById(id).getOrdersId();
        //System.out.println("您确定要删除OrderId为"+orderId+"的数据吗？");
        Integer deletedRows = detailRepo.deleteDetailsById(id);
        //然后再更新order表
        this.updateOrSaveOrder(orderId);
        return "已删除details" + deletedRows + "条";
    }

    @Transactional
    public String deleteByIds(Collection<Integer> ids)
    {
        Integer deletedRows = 0;
        for(Integer id : ids)
        {
            //先查找orderId 以便后面进行order表的更新
            Integer orderId = detailRepo.findOneById(id).getOrdersId();
            //System.out.println("您确定要删除OrderId为"+orderId+"的数据吗？");
            deletedRows += detailRepo.deleteDetailsById(id);
            //然后再更新order表
            this.updateOrSaveOrder(orderId);
        }
        return "已删除details"+deletedRows+"条";
    }

    @Transactional
    public Order updateOrSaveOrder(Integer orderId)
    {
        Order orderToUpdate = orderRepo.findOne(orderId);
        if(orderToUpdate==null)
        {
            orderToUpdate = new Order();
        }
        List<Detail> details = detailRepo.getDetailsByOrdersId(orderId);
        int totalPrice = 0;
        for(Detail detail : details)
        {
            totalPrice += detail.getPrice()*detail.getQuantity();
        }
        orderToUpdate.setTotalPrice(totalPrice);
        return orderRepo.save(orderToUpdate);
    }
}
