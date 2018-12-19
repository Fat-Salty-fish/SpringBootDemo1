package com.copy.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "table_details")
@Getter
@Setter
public class Details {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id ; //详情id 主键

    @Column
    private int ordersId ; //所属订单号 为外键

    @Column
    private int quantity ; //此货物数量

    @Column
    private int price ;  //此货物的单价

    @Column
    private String nameOfArtifact ; //此货物的货物名

}
