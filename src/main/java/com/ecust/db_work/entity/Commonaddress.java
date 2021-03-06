package com.ecust.db_work.entity;

import javax.persistence.*;

@Entity
public class Commonaddress {
    private int id;
    private String customerId;
    private boolean sendAddress;
    private String address;
    private String targetUser;

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
    @Column(name = "customerID", nullable = false, length = 10)
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "sendAddress", nullable = false)
    public boolean isSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(boolean sendAddress) {
        this.sendAddress = sendAddress;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "targetUser", nullable = true, length = 5)
    public String getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(String targetUser) {
        this.targetUser = targetUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commonaddress that = (Commonaddress) o;

        if (id != that.id) return false;
        if (sendAddress != that.sendAddress) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (targetUser != null ? !targetUser.equals(that.targetUser) : that.targetUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (sendAddress ? 1 : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (targetUser != null ? targetUser.hashCode() : 0);
        return result;
    }

}
