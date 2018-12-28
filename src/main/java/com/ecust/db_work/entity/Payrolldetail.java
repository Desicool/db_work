package com.ecust.db_work.entity;

import javax.persistence.*;

@Entity
public class Payrolldetail {
    private int id;
    private String type;
    private double money;
    private Payroll payrollByPayrollId;
    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "money", nullable = false, precision = 0)
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payrolldetail that = (Payrolldetail) o;

        if (id != that.id) return false;
        if (Double.compare(that.money, money) != 0) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(money);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "payrollId", referencedColumnName = "payrollId", nullable = false)
    public Payroll getPayrollByPayrollId() {
        return payrollByPayrollId;
    }

    public void setPayrollByPayrollId(Payroll payrollByPayrollId) {
        this.payrollByPayrollId = payrollByPayrollId;
    }
}
