package com.ecust.db_work.utils;

import com.ecust.db_work.entity.Deliveryinfo;
import com.ecust.db_work.entity.Expressorder;

import java.util.Iterator;
import java.util.List;

public class DeliveryInfoUtil {
    public static String DeliveryInfoToHTML(List<Deliveryinfo> list){
        String ans="<table border =\"1\"><tr><th>中转编号</th><th>发出站点</th>" +
            "<th>发出负责人</th><th>收件站点</th><th>收件负责人</th><th>状态</th><th>备注</th></tr>";
        Iterator<Deliveryinfo> iterator = list.iterator();
        while(iterator.hasNext()) {
            Deliveryinfo deliveryinfo = iterator.next();
            ans += "<tr>";
            ans += "<td>" + deliveryinfo.getDeliveryId() + "</td>";
            ans += "<td>" + deliveryinfo.getStationBySendStation().getName() + "</td>";
            ans += "<td>" + deliveryinfo.getEmployeeBySendPrinciple().getName() + "</td>";
            ans += "<td>" + deliveryinfo.getStationByReceiveStation().getName()+"</td>";
            ans += "<td>" + deliveryinfo.getEmployeeByReceivePrinciple().getName()+"</td>";
            ans += "<td>" + deliveryinfo.getStatus()+"</td>";
            ans += "<td>" + deliveryinfo.getAdditional()+"</td>";
            ans += "</tr>";
        }
        ans += "</table>";
        return ans;
    }
}
