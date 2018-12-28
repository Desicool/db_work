package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Deliveryinfo;

import java.util.List;

public interface DeliveryInfoRepository extends baseRepository<Deliveryinfo, Integer>{
    List<Deliveryinfo> findByDeliveryID(List<String> deliveryID);
}
