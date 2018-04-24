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

    @Column(unique = true, updatable = false)
    private String englishName;

    @Column
    private String address;

    @Column
    private String establishedTime;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column
    private double deposit;

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    private double credit;

    public Operator(String operatorName, String englishName, String address, String establishedTime, LocalDateTime createTime, double deposit, double credit, int isRunning, String leader) {
        this.operatorName = operatorName;
        this.englishName = englishName;
        this.address = address;
        this.establishedTime = establishedTime;
        this.createTime = createTime;
        this.deposit = deposit;
        this.credit = credit;
        this.isRunning = isRunning;
        this.leader = leader;
    }

    /**
     * 1 运行状态，积分、押金正常显示
     * 0 停运状态，积分、押金显示为0

     */
    @Column
    private int isRunning;

    @Column
    private String leader;


    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEstablishedTime(String establishedTime) {
        this.establishedTime = establishedTime;
    }

    public void setIsRunning(int isRunning) {
        this.isRunning = isRunning;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getAddress() {
        return address;
    }

    public String getEstablishedTime() {
        return establishedTime;
    }

    public int getIsRunning() {
        return isRunning;
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
