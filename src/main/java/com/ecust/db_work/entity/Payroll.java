package com.ecust.db_work.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Payroll {
    private String payrollId;
    private Date payTime;
    private Employee employeeByEmployeeId;
    private List<Payrolldetail> payrolldetailsByPayrollId;

    @Id
    @Column(name = "payrollID", nullable = false, length = 10)
    public String getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(String payrollId) {
        this.payrollId = payrollId;
    }

    @Basic
    @Column(name = "payTime", nullable = false)
    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payroll payroll = (Payroll) o;

        if (payrollId != null ? !payrollId.equals(payroll.payrollId) : payroll.payrollId != null) return false;
        if (payTime != null ? !payTime.equals(payroll.payTime) : payroll.payTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = payrollId != null ? payrollId.hashCode() : 0;
        result = 31 * result + (payTime != null ? payTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "employeeID", referencedColumnName = "employeeID", nullable = false)
    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    @OneToMany(mappedBy = "payrollByPayrollId")
    public List<Payrolldetail> getPayrolldetailsByPayrollId() {
        return payrolldetailsByPayrollId;
    }

    public void setPayrolldetailsByPayrollId(List<Payrolldetail> payrolldetailsByPayrollId) {
        this.payrolldetailsByPayrollId = payrolldetailsByPayrollId;
    }
}
