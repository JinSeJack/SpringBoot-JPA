package com.ibike.credit.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Table(name = "rule")
public class Rule {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column(updatable = false)
    @LastModifiedDate
    private LocalDateTime updateTime;

    private String ruleName;

    /**
     * 积分规则：正数加分、负数减分
     */
    private double point;

    private String description;

    /**
     * 1 已经审核
     * 0 未审核
     */
    private int isChecked;
}
