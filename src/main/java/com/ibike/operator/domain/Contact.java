package com.ibike.operator.domain;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Table(name = "contact")
@Entity
public class Contact {

	@Id
    @GeneratedValue
    private Integer id;
	
	@Column(unique = true, updatable = false)
    private String contactName;
	
	@Column(updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column
    @LastModifiedDate
    private LocalDateTime updateTime;
    
    @Column
    private String phone;

    @ManyToOne
    private Operator operator;

    /*
     * 一个人一个属性，
     */
    @Column
    private String type;

    /**
     * 1 已经审核
     * 0 未审核
     */
    @Column
    private int isChecked;

    public Contact() {
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", contactName='" + contactName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", phone='" + phone + '\'' +
                ", operator=" + operator +
                ", type='" + type + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getContactName() {
        return contactName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public String getPhone() {
        return phone;
    }

    public String getType() {
        return type;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public Contact(String contactName, LocalDateTime createTime, LocalDateTime updateTime, String phone, Operator operator, String type, int isChecked) {
        this.contactName = contactName;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.phone = phone;
        this.operator = operator;
        this.type = type;
        this.isChecked = isChecked;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }
}
