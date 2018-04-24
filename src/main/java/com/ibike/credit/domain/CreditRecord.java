package com.ibike.credit.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "creditrecord")
public class CreditRecord {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column
    @LastModifiedDate
    private LocalDateTime updateTime;

    /**
     * 暂时名称代替
     */
    @Column
    private String operatorName;

    @ManyToOne
    private CreditRule rule;

    /**
     * 1 已经审核
     * 0 未审核
     */
    @Column
    private int isChecked;



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

    @Override
    public String toString() {
        return "CreditRecord{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", operatorName='" + operatorName + '\'' +
                ", rule=" + rule +
                ", isChecked=" + isChecked +
                '}';
    }

    public CreditRule getRule() {
        return rule;
    }

    public void setRule(CreditRule rule) {
        this.rule = rule;
    }

    public CreditRecord(LocalDateTime createTime, LocalDateTime updateTime, String operatorName, CreditRule rule, int isChecked) {

        this.createTime = createTime;
        this.updateTime = updateTime;
        this.operatorName = operatorName;
        this.rule = rule;
        this.isChecked = isChecked;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    public CreditRecord() {

    }


}
