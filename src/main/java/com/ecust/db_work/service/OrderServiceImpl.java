package com.ecust.db_work.service;

import com.ecust.db_work.entity.Deliveryinfo;
import com.ecust.db_work.entity.Employee;
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

    @Override
    public Integer insertDeliveryInfo(String orderID, Employee employee, String additional) {
        List<Deliveryinfo> listB = getDeliveryinfo(orderID);
        int num = listB.size();
        List<String> deliveryId = new ArrayList<>();
        for(Deliveryinfo x : listB){
            deliveryId.add(x.getDeliveryId());
        }
        Deliveryinfo maxDelivery = deliveryInfoRepository.findLastTransferredOne(deliveryId);
        if(maxDelivery == null) {
            maxDelivery = new Deliveryinfo();
            maxDelivery.setDeliveryId(deliveryInfoRepository.generatedDeliveryID());
            maxDelivery.setEmployeeByReceivePrinciple(employee);
            maxDelivery.setStationByReceiveStation(employee.getStationByStationID());
            maxDelivery.setStatus(1);
            maxDelivery.setAdditional("快递从客户手中到快递站");
            maxDelivery.setTransferNum(num++);
            OrderDelivery tmp = new OrderDelivery();
            tmp.setDeliveryId(maxDelivery.getDeliveryId());
            tmp.setOrderId(orderID);
            orderDeliveryRepository.save(tmp);
            deliveryInfoRepository.save(maxDelivery);
        }
        else {
            maxDelivery.setEmployeeByReceivePrinciple(employee);
            maxDelivery.setStationByReceiveStation(employee.getStationByStationID());
            maxDelivery.setAdditional((maxDelivery.getAdditional() == null? "" : maxDelivery.getAdditional()) + additional);
            maxDelivery.setStatus(1);
            deliveryInfoRepository.update(maxDelivery);
            deliveryInfoRepository.flush();
        }
        Deliveryinfo deliveryinfo = new Deliveryinfo();
        deliveryinfo.setStatus(0);
        deliveryinfo.setDeliveryId(deliveryInfoRepository.generatedDeliveryID());
        deliveryinfo.setEmployeeBySendPrinciple(employee);
        deliveryinfo.setStationBySendStation(employee.getStationByStationID());
        deliveryinfo.setTransferNum(num);
        OrderDelivery orderDelivery = new OrderDelivery();
        orderDelivery.setOrderId(orderID);
        orderDelivery.setDeliveryId(deliveryinfo.getDeliveryId());
        orderDeliveryRepository.save(orderDelivery);
        return deliveryInfoRepository.save(deliveryinfo);
    }

    @Override
    public void checkDelivery(String orderID, Employee employee, String additional) {
        List<Deliveryinfo> listB = getDeliveryinfo(orderID);
        int num = listB.size();
        List<String> deliveryId = new ArrayList<>();
        for(Deliveryinfo x : listB){
            deliveryId.add(x.getDeliveryId());
        }
        Deliveryinfo maxDelivery = deliveryInfoRepository.findLastTransferredOne(deliveryId);
        if(maxDelivery == null) {
            maxDelivery = new Deliveryinfo();
            maxDelivery.setDeliveryId(deliveryInfoRepository.generatedDeliveryID());
            maxDelivery.setEmployeeByReceivePrinciple(employee);
            maxDelivery.setStationByReceiveStation(employee.getStationByStationID());
            maxDelivery.setStatus(1);
            maxDelivery.setAdditional("无");
            maxDelivery.setTransferNum(num++);
            OrderDelivery tmp = new OrderDelivery();
            tmp.setDeliveryId(maxDelivery.getDeliveryId());
            tmp.setOrderId(orderID);
            orderDeliveryRepository.save(tmp);
            deliveryInfoRepository.save(maxDelivery);
        }
        else {
            maxDelivery.setEmployeeByReceivePrinciple(employee);
            maxDelivery.setStationByReceiveStation(employee.getStationByStationID());
            maxDelivery.setAdditional(maxDelivery.getAdditional());
            maxDelivery.setStatus(1);
            deliveryInfoRepository.update(maxDelivery);
            deliveryInfoRepository.flush();
        }
        Deliveryinfo deliveryinfo = new Deliveryinfo();
        deliveryinfo.setStatus(1);
        deliveryinfo.setDeliveryId(deliveryInfoRepository.generatedDeliveryID());
        deliveryinfo.setEmployeeBySendPrinciple(employee);
        deliveryinfo.setStationBySendStation(employee.getStationByStationID());
        deliveryinfo.setTransferNum(num);
        deliveryinfo.setAdditional("快递送达收件人手中");
        OrderDelivery orderDelivery = new OrderDelivery();
        orderDelivery.setOrderId(orderID);
        orderDelivery.setDeliveryId(deliveryinfo.getDeliveryId());
        orderDeliveryRepository.save(orderDelivery);
        deliveryInfoRepository.save(deliveryinfo);
    }
}
