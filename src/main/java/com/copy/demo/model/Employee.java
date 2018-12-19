package com.copy.demo.model;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

@Entity
@Table(
        name = "table_employee"
)
@Setter
@Getter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //主键 自动递增
    private int id ;

    @Column(name = "name")
    private String name;

    @Column(name ="department")
    private String department;

    @Column (name = "address")
    private String address;
}
