package com.ibike.operator.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Set;

@Table(name = "operator")
@Entity
public class Operator {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, updatable = false)
    private String operatorName;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column
    private double deposit;

    /**
     * 1 已经审核
     * 0 未审核
     */
    @Column
    private int isDepositChecked;

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", operatorName='" + operatorName + '\'' +
                ", createTime=" + createTime +
                ", deposit=" + deposit +
                ", isDepositChecked=" + isDepositChecked +
                '}';
    }

    public Operator(String operatorName, LocalDateTime createTime, double deposit, int isDepositChecked) {
        this.operatorName = operatorName;
        this.createTime = createTime;
        this.deposit = deposit;
        this.isDepositChecked = isDepositChecked;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public int getIsDepositChecked() {
        return isDepositChecked;
    }

    public void setIsDepositChecked(int isDepositChecked) {
        this.isDepositChecked = isDepositChecked;
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

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Operator() {

    }

}
