package com.wu.greenfarm.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class FarmOrder {

    private int id;

    private int farmId;

    private int customerId;

    private int status;

    private Date updateTime;//订单最近一次更新的时间

    private String address;

    public FarmOrder() {
    }

    public FarmOrder(int id, int farmId, int customerId, int status, Date updateTime, String address) {
        this.id = id;
        this.farmId = farmId;
        this.customerId = customerId;
        this.status = status;
        this.updateTime = updateTime;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "FarmOrder{" +
                "id=" + id +
                ", farmId=" + farmId +
                ", customerId=" + customerId +
                ", status=" + status +
                ", updateTime=" + updateTime +
                ", address='" + address + '\'' +
                '}';
    }
}
