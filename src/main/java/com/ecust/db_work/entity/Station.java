package com.ecust.db_work.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Station {
    private String stationId;
    private String address;
    private String phone;
    private Collection<Deliveryinfo> deliveryinfosByStationId;
    private Collection<Deliveryinfo> deliveryinfosByStationId_0;
    private Collection<Employee> employeesByStationId;

    @Id
    @Column(name = "stationID", nullable = false, length = 10)
    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
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
    @Column(name = "phone", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (stationId != null ? !stationId.equals(station.stationId) : station.stationId != null) return false;
        if (address != null ? !address.equals(station.address) : station.address != null) return false;
        if (phone != null ? !phone.equals(station.phone) : station.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stationId != null ? stationId.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "stationBySendStation")
    public Collection<Deliveryinfo> getDeliveryinfosByStationId() {
        return deliveryinfosByStationId;
    }

    public void setDeliveryinfosByStationId(Collection<Deliveryinfo> deliveryinfosByStationId) {
        this.deliveryinfosByStationId = deliveryinfosByStationId;
    }

    @OneToMany(mappedBy = "stationByReceiveStation")
    public Collection<Deliveryinfo> getDeliveryinfosByStationId_0() {
        return deliveryinfosByStationId_0;
    }

    public void setDeliveryinfosByStationId_0(Collection<Deliveryinfo> deliveryinfosByStationId_0) {
        this.deliveryinfosByStationId_0 = deliveryinfosByStationId_0;
    }

    @OneToMany(mappedBy = "stationByStationId")
    public Collection<Employee> getEmployeesByStationId() {
        return employeesByStationId;
    }

    public void setEmployeesByStationId(Collection<Employee> employeesByStationId) {
        this.employeesByStationId = employeesByStationId;
    }
}
