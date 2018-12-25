package com.ecust.db_work.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Employee {
    private String employeeId;
    private Date birthday;
    private Date entryTime;
    private String stationId;
    private Date separationTime;
    private String job;
    private String phone;
    private String sex;

    @Id
    @Column(name = "employeeID", nullable = false, length = 10)
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "birthday", nullable = false)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "entryTime", nullable = false)
    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    @Basic
    @Column(name = "stationID", nullable = false, length = 10)
    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    @Basic
    @Column(name = "separationTime", nullable = false)
    public Date getSeparationTime() {
        return separationTime;
    }

    public void setSeparationTime(Date separationTime) {
        this.separationTime = separationTime;
    }

    @Basic
    @Column(name = "job", nullable = false, length = 10)
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

        Employee employee = (Employee) o;

        if (employeeId != null ? !employeeId.equals(employee.employeeId) : employee.employeeId != null) return false;
        if (birthday != null ? !birthday.equals(employee.birthday) : employee.birthday != null) return false;
        if (entryTime != null ? !entryTime.equals(employee.entryTime) : employee.entryTime != null) return false;
        if (stationId != null ? !stationId.equals(employee.stationId) : employee.stationId != null) return false;
        if (separationTime != null ? !separationTime.equals(employee.separationTime) : employee.separationTime != null)
            return false;
        if (job != null ? !job.equals(employee.job) : employee.job != null) return false;
        if (phone != null ? !phone.equals(employee.phone) : employee.phone != null) return false;
        if (sex != null ? !sex.equals(employee.sex) : employee.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (entryTime != null ? entryTime.hashCode() : 0);
        result = 31 * result + (stationId != null ? stationId.hashCode() : 0);
        result = 31 * result + (separationTime != null ? separationTime.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
