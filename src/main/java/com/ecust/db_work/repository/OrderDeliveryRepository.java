package com.ecust.db_work.repository;

import com.ecust.db_work.entity.OrderDelivery;

import java.util.List;

public interface OrderDeliveryRepository extends baseRepository<OrderDelivery,Integer> {
    List<OrderDelivery> findByOrderID(String orderID);
}
