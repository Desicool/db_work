package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Deliveryinfo;

public interface DeliveryInfoRepository extends baseRepository<Deliveryinfo, Integer>{
    Deliveryinfo findByDeliveryID(String DeliveryID);
}
