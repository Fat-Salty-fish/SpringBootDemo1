package com.copy.demo.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table( name = "table_orders")
@Getter
@Setter

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;//订单主键

//    @Column(unique = true)
//    private String serial = UUID.randomUUID().toString();//订单序列号 随机生成 唯一

    @Column
    private String orderType ; //订单类型

    @Column
    private int totalPrice; //订单总价

    @Column
    private Date generatedTime; //订单生成时间

    @Column
    private String buyer ; //订单所属客户姓名

    @Transient
    private Set<Details> details = new HashSet<>();

}
