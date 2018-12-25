package com.ecust.db_work.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    private String customerId;
    private String name;
    private String sex;
    private List<Commonaddress> commonaddressesByCustomerId;
    private List<Expressorder> expressordersByCustomerId;

    @Id
    @Column(name = "customerID", nullable = false, length = 10)
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 5)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex", nullable = false, length = 2)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != null ? !customerId.equals(customer.customerId) : customer.customerId != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (sex != null ? !sex.equals(customer.sex) : customer.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public List<Commonaddress> getCommonaddressesByCustomerId() {
        return commonaddressesByCustomerId;
    }

    public void setCommonaddressesByCustomerId(List<Commonaddress> commonaddressesByCustomerId) {
        this.commonaddressesByCustomerId = commonaddressesByCustomerId;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public List<Expressorder> getExpressordersByCustomerId() {
        return expressordersByCustomerId;
    }

    public void setExpressordersByCustomerId(List<Expressorder> expressordersByCustomerId) {
        this.expressordersByCustomerId = expressordersByCustomerId;
    }
}
