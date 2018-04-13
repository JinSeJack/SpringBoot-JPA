package com.ibike.operator.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "place")
@Entity
public class Place {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, updatable = false)
    private String placeName;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column
    @LastModifiedDate
    private LocalDateTime updateTime;

    /**
     * 1 已经审核
     * 0 未审核
     */
    @Column
    private int isChecked;

    @Column
    private String role;

    @ManyToOne
    private Operator operator;

    @Column
    private double latitude;

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", placeName='" + placeName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isChecked=" + isChecked +
                ", role='" + role + '\'' +
                ", operator=" + operator +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Column
    private double longitude;

    public Place() {
    }

    public Place(String placeName, LocalDateTime createTime, LocalDateTime updateTime, int isChecked, String role, Operator operator, double latitude, double longitude) {
        this.placeName = placeName;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isChecked = isChecked;
        this.role = role;
        this.operator = operator;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public String getRole() {
        return role;
    }

    public Operator getOperator() {
        return operator;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
