package com.ecust.db_work.entity;

import javax.persistence.*;

@Entity
@Table(name = "`order-delivery`", schema = "db_work")
public class OrderDelivery {
    private int id;
    private String orderId;
    private String deliveryId;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "orderID", nullable = false, length = 10)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "deliveryID", nullable = false, length = 10)
    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDelivery that = (OrderDelivery) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (deliveryId != null ? !deliveryId.equals(that.deliveryId) : that.deliveryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (deliveryId != null ? deliveryId.hashCode() : 0);
        return result;
    }
}
