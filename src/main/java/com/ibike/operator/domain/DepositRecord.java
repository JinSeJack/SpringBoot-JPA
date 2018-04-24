package com.ibike.operator.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "depositrecord")
@Entity
public class DepositRecord {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Operator operator;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column
    @LastModifiedDate
    private LocalDateTime updateTime;

    public DepositRecord(Operator operator, LocalDateTime createTime, LocalDateTime updateTime, int isDepositChecked, double deposit) {
        this.operator = operator;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDepositChecked = isDepositChecked;
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "DepositRecord{" +
                "id=" + id +
                ", operator=" + operator +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDepositChecked=" + isDepositChecked +
                ", deposit=" + deposit +
                '}';
    }

    public DepositRecord() {
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
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

    public int getIsDepositChecked() {
        return isDepositChecked;
    }

    public void setIsDepositChecked(int isDepositChecked) {
        this.isDepositChecked = isDepositChecked;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    /**
     * 1 已经审核，审核通过同时应该更新运营商的押金余额

     * 0 未审核
     */
    @Column
    private int isDepositChecked;

    /**
     * 单次押金值，正-存 负-取
     */
    @Column
    private double deposit;
}
