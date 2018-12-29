package com.ecust.db_work.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Expressorder {
    private String orderNo;
    private String receiveAddress;
    private String sentAddress;
    private Date orderDate;
    private double payment;
    private String receiverName;
    private Customer expressOrderByCustomer;
    private boolean status;
    @Id
    @Column(name = "orderNo", nullable = false, length = 10)
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Basic
    @Column(name = "receiveAddress", nullable = false, length = 50)
    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    @Basic
    @Column(name = "sentAddress", nullable = false, length = 50)
    public String getSentAddress() {
        return sentAddress;
    }

    public void setSentAddress(String sentAddress) {
        this.sentAddress = sentAddress;
    }

    @Basic
    @Column(name = "orderDate", nullable = true)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "payment", nullable = false, precision = 0)
    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "receiverName", nullable = false, length = 5)
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @Basic
    @Column(name = "status", nullable =  false)
    public  boolean isStatus(){return status;}
    public void setStatus(boolean status){this.status = status;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expressorder that = (Expressorder) o;

        if (Double.compare(that.payment, payment) != 0) return false;
        if (orderNo != null ? !orderNo.equals(that.orderNo) : that.orderNo != null) return false;
        if (receiveAddress != null ? !receiveAddress.equals(that.receiveAddress) : that.receiveAddress != null)
            return false;
        if (sentAddress != null ? !sentAddress.equals(that.sentAddress) : that.sentAddress != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (receiverName != null ? !receiverName.equals(that.receiverName) : that.receiverName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = orderNo != null ? orderNo.hashCode() : 0;
        result = 31 * result + (receiveAddress != null ? receiveAddress.hashCode() : 0);
        result = 31 * result + (sentAddress != null ? sentAddress.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        temp = Double.doubleToLongBits(payment);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (receiverName != null ? receiverName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customerID", referencedColumnName = "customerID", nullable = false)
    public Customer getExpressOrderByCustomer() {
        return expressOrderByCustomer;
    }

    public void setExpressOrderByCustomer(Customer expressOrderByCustomer) {
        this.expressOrderByCustomer = expressOrderByCustomer;
    }
}
