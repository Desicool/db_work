package com.ecust.db_work.service;

import com.ecust.db_work.entity.Deliveryinfo;

import java.util.List;

public interface OrderService {
    List<Deliveryinfo> getDeliveryinfo(String orderID);
}
