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
            if(deliveryinfo.getStationBySendStation() != null)
                ans += "<td>" + deliveryinfo.getStationBySendStation().getName() + "</td>";
            else
                ans += "<td> </td>";
            if(deliveryinfo.getEmployeeBySendPrinciple() != null)
                ans += "<td>" + deliveryinfo.getEmployeeBySendPrinciple().getName() + "</td>";
            else
                ans +="<td> </td>";
            if( deliveryinfo.getStationByReceiveStation() != null)
                ans += "<td>" + deliveryinfo.getStationByReceiveStation().getName()+"</td>";
            else
                ans += "<td></td>";
            if(deliveryinfo.getEmployeeByReceivePrinciple() != null)
                ans += "<td>" + deliveryinfo.getEmployeeByReceivePrinciple().getName()+"</td>";
            else
                ans += "<td> </td>";
            ans += "<td>" + (deliveryinfo.getStatus() == 1? "已送达":"运送中")+"</td>";
            String tmp = deliveryinfo.getAdditional();
            if(tmp == null)
                tmp = "";
            ans += "<td>" + tmp +"</td>";
            ans += "</tr>";
        }
        ans += "</table>";
        return ans;
    }
    public static String DeliveryInfoInsertHTML(){
        String ans = "<table border=\"0\">" +
            "<tr><td>订单号：</td><td><input type=\"text\" class=\"text-input\" name=\"orderID\"></td></tr>";
        ans += "<tr><td>备注：</td><td><input type=\"text\" class=\"text-input\" name=\"additional\"></td></tr>";
        ans += "</table>";
        ans += "<input type=\"submit\" value=\"确认中转\">";
        /*ans += "<input type=\"text\" name=\"isSendAddress\" value=\"" + "" +
                "\" style=\"display:none\">";*/
        return ans;
    }
    public static String CheckDeliveryInfoHTML(){
        String ans = "<table border=\"0\">" +
                "<tr><td>订单号：</td><td><input type=\"text\" class=\"text-input\" name=\"orderID\"></td></tr>";
        ans += "<tr><td>备注：</td><td><input type=\"text\" class=\"text-input\" name=\"additional\"></td></tr>";
        ans += "</table>";
        ans += "<input type=\"submit\" value=\"确认送达\">";
        /*ans += "<input type=\"text\" name=\"isSendAddress\" value=\"" + "" +
                "\" style=\"display:none\">";*/
        return ans;
    }
}
