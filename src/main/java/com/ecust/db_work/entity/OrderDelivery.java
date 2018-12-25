package com.ecust.db_work.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order-delivery", schema = "db_work", catalog = "")
public class OrderDelivery {
    private String orderId;
    private List<Deliveryinfo> deliveryInfoBydeliveryId;

    @Id
    @Column(name = "orderID", nullable = false, length = 10)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDelivery that = (OrderDelivery) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return orderId != null ? orderId.hashCode() : 0;
    }

    @OneToMany
    public List<Deliveryinfo> getDeliveryInfoBydeliveryId() {
        return deliveryInfoBydeliveryId;
    }

    public void setDeliveryInfoBydeliveryId(List<Deliveryinfo> deliveryInfoBydeliveryId) {
        this.deliveryInfoBydeliveryId = deliveryInfoBydeliveryId;
    }
}
