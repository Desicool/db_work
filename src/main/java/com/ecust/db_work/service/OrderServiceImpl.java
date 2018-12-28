package com.ecust.db_work.service;

import com.ecust.db_work.entity.Deliveryinfo;
import com.ecust.db_work.entity.OrderDelivery;
import com.ecust.db_work.repository.DeliveryInfoRepositoryImpl;
import com.ecust.db_work.repository.OrderDeliveryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements  OrderService {
    @Autowired
    private OrderDeliveryRepositoryImpl orderDeliveryRepository;
    @Autowired
    private DeliveryInfoRepositoryImpl deliveryInfoRepository;
    @Override
    public List<Deliveryinfo> getDeliveryinfo(String orderID) {
        List<OrderDelivery> tmp = orderDeliveryRepository.findByOrderID(orderID);
        List<String> deliveryID = new ArrayList<>();
        for(OrderDelivery item : tmp){
            deliveryID.add(item.getDeliveryId());
        }
        return deliveryInfoRepository.findByDeliveryID(deliveryID);
    }
}
