package com.ecust.db_work.service;

import com.ecust.db_work.entity.Deliveryinfo;
import com.ecust.db_work.entity.Employee;

import java.util.List;

public interface OrderService {
    List<Deliveryinfo> getDeliveryinfo(String orderID);
    Integer insertDeliveryInfo(String orderID, Employee employee,String additional);
    void checkDelivery(String orderID,Employee employee,String additional);
}
