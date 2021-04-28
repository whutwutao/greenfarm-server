package com.wu.greenfarm.pojo;

public class ProductOrder {

    private int id;

    private int customerId;

    private int farmerId;

    private int productId;

    private int status;

    public ProductOrder() {
    }

    public ProductOrder(int id, int customerId, int farmerId, int productId, int status) {
        this.id = id;
        this.customerId = customerId;
        this.farmerId = farmerId;
        this.productId = productId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", farmerId=" + farmerId +
                ", productId=" + productId +
                ", status=" + status +
                '}';
    }
}
