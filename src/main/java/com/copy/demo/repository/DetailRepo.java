package com.copy.demo.repository;

import com.copy.demo.model.Detail;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface DetailRepo extends CrudRepository<Detail,Integer> {
    // 根据单个订单表的id 将相关details全部删除
    public Integer deleteAllByOrdersId(Integer id);
    // 根据多个订单表的id将相关details全部删除
    public Integer deleteAllByOrdersIdIn(Collection<Integer> ids);

    //根据单个detailsID将相关货物删除
    public int deleteDetailsById(Integer id);
    //根据多个detailsID将相关货物全部删除
    public int deleteDetailsByIdIn(Collection<Integer> ids);

    //根据OrderID搜索相关details
    public List<Detail> getDetailsByOrdersId(Integer orderId);

    //根据id获取一条detail
    public Detail findOneById(Integer id);


}
