package com.ecust.db_work.entity;

import javax.persistence.*;

@Entity
public class Deliveryinfo {
    private int id;
    private String deliveryId;
    private int status;
    private String additional;
    private int transferNum;
    private Station stationBySendStation;
    private Station stationByReceiveStation;
    private Employee employeeByReceivePrinciple;
    private Employee employeeBySendPrinciple;

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
    @Column(name = "deliveryID", nullable = false, length = 10)
    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "additional", nullable = true, length = 50)
    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    @Basic
    @Column(name = "transferNum", nullable = false)
    public int getTransferNum() {
        return transferNum;
    }

    public void setTransferNum(int transferNum) {
        this.transferNum = transferNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deliveryinfo that = (Deliveryinfo) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (transferNum != that.transferNum) return false;
        if (deliveryId != null ? !deliveryId.equals(that.deliveryId) : that.deliveryId != null) return false;
        if (additional != null ? !additional.equals(that.additional) : that.additional != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (deliveryId != null ? deliveryId.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (additional != null ? additional.hashCode() : 0);
        result = 31 * result + transferNum;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "sendStation", referencedColumnName = "stationID", nullable = false)
    public Station getStationBySendStation() {
        return stationBySendStation;
    }

    public void setStationBySendStation(Station stationBySendStation) {
        this.stationBySendStation = stationBySendStation;
    }

    @ManyToOne
    @JoinColumn(name = "receiveStation", referencedColumnName = "stationID")
    public Station getStationByReceiveStation() {
        return stationByReceiveStation;
    }

    public void setStationByReceiveStation(Station stationByReceiveStation) {
        this.stationByReceiveStation = stationByReceiveStation;
    }

    @ManyToOne
    @JoinColumn(name = "receivePrinciple", referencedColumnName = "employeeID", nullable = false)
    public Employee getEmployeeByReceivePrinciple() {
        return employeeByReceivePrinciple;
    }

    public void setEmployeeByReceivePrinciple(Employee employeeByReceivePrinciple) {
        this.employeeByReceivePrinciple = employeeByReceivePrinciple;
    }

    @ManyToOne
    @JoinColumn(name = "sendPrinciple", referencedColumnName = "employeeID")
    public Employee getEmployeeBySendPrinciple() {
        return employeeBySendPrinciple;
    }

    public void setEmployeeBySendPrinciple(Employee employeeBySendPrinciple) {
        this.employeeBySendPrinciple = employeeBySendPrinciple;
    }
}
