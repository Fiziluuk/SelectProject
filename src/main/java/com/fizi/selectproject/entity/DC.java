package com.fizi.selectproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter       //自动生成getter/setter方法
@NoArgsConstructor   //自动生成无参的构造函数
public class DC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //生成的策略 让id这个主键自增长
    private int id;

    @ManyToOne
    private Direction direction;

    @ManyToOne
    private Course course;
    //权重
    private double weight;

}
