package com.copy.demo.repository;

import com.copy.demo.model.Details;
import org.springframework.data.repository.CrudRepository;

public interface DetailsRepo extends CrudRepository<Details,Integer> {
    // 根据订单表的id 将相关详细货物全部删除
    public Details deleteAllByOrdersId(int id);

    //根据货物名字删除货物信息
    public void deleteByNameOfArtifact(String name);

}
