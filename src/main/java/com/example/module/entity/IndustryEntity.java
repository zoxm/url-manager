package com.example.module.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Accessors(chain = true)
@Table(schema = "industry", name = "industry")

public class IndustryEntity extends BaseEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", columnDefinition = "varchar(225) not null COMMENT '标签'")
    private String name;
    @Column(name = "href", columnDefinition = "varchar(225) not null COMMENT '网址'")
    private String href;
    @Column(name = "max_page", columnDefinition = "int default -1 COMMENT '最大页码'")
    private Integer maxPage = 9999;
    @Column(name = "done", columnDefinition = "int default 1 COMMENT '已经完成页码'")
    private Integer done = 0;
}
