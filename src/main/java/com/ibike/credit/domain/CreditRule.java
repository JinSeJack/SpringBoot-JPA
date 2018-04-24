package com.ibike.credit.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rule")
public class CreditRule {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column(updatable = false)
    @LastModifiedDate
    private LocalDateTime updateTime;

    @Column(updatable = false)
    private String name;

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

    @Override
    public String toString() {
        return "CreditRule{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", name='" + name + '\'' +
                ", point=" + point +
                ", description='" + description + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }

    public CreditRule(LocalDateTime createTime, LocalDateTime updateTime, String name, double point, String description, int isChecked) {
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.name = name;
        this.point = point;
        this.description = description;
        this.isChecked = isChecked;
    }

    public CreditRule() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }


}
