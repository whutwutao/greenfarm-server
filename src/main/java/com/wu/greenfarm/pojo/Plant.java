package com.wu.greenfarm.pojo;

/**
 * 种植记录
 */
public class Plant {

    private int id;

    private int farmId;

    private int customerId;

    private int productId;

    private String amount;

    private int status;

    public Plant() {
    }

    public Plant(int id, int farmId, int customerId, int productId, String amount, int status) {
        this.id = id;
        this.farmId = farmId;
        this.customerId = customerId;
        this.productId = productId;
        this.amount = amount;
        this.status = status;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", farmId=" + farmId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", amount='" + amount + '\'' +
                ", status=" + status +
                '}';
    }
}
