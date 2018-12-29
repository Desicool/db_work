package com.ecust.db_work.utils;

import com.ecust.db_work.entity.Commonaddress;
import com.ecust.db_work.entity.Customer;
import com.ecust.db_work.entity.Expressorder;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerUtil {
    public static String CustomerToHTML(Customer customer) {
        String ans="<table border =\"1\"><tr><th>编号</th><th>姓名</th><th>性别</th><th>..</th></tr>";
        ans += "<tr>";
        ans += "<td>" + customer.getCustomerId()+"</td>";
        ans += "<td>" + customer.getName()+"</td>";
        ans += "<td>" + customer.getSex()+"</td>";
        ans += "<td><a href='/customerDetail.jmp?customerID="+customer.getCustomerId()+"'>详细信息</a></td>";
        ans += "</tr>";
            // ans = ans + "<a href='product?id=" + product.getProductId() + "'>查看商品详情</a><br>";
        ans += "</table>";
        return ans;
    }
    public static String CustomerListToHTML(List<Customer> list) {
        String ans="<table border =\"1\"><tr><th>编号</th><th>姓名</th><th>性别</th><th>..</th></tr>";
        Iterator<Customer> iterator = list.iterator();
        while(iterator.hasNext()) {
            Customer customer = iterator.next();
            ans += "<tr>";
            ans += "<td>" + customer.getCustomerId() + "</td>";
            ans += "<td>" + customer.getName() + "</td>";
            ans += "<td>" + customer.getSex() + "</td>";
            ans += "<td><a href='/customerDetail.jmp?customerID="+customer.getCustomerId()+"'>详细信息</a></td>";
            ans += "</tr>";
        }
        // ans = ans + "<a href='product?id=" + product.getProductId() + "'>查看商品详情</a><br>";
        ans += "</table>";
        return ans;
    }
    public static List<String> CommonAddressToHTML(List<Commonaddress> originList,boolean isCustomer){
        List<Commonaddress> send = new ArrayList<>();
        List<Commonaddress> receive = new ArrayList<>();
        for(Commonaddress item : originList)
        {
            if(item.isSendAddress())
                send.add(item);
            else
                receive.add(item);
        }
        String sendHTML = "<table border =\"1\"><tr><th>编号</th><th>发件人</th><th>地址</th>" +
                (isCustomer?"<th><a href=/insertAddress?isSendAddress=true>添加..</a></th><th><a>烫烫烫</a></th>":"")
                + "</tr>",
                receiveHTML="<table border =\"1\"><tr><th>编号</th><th>收件人</th><th>地址</th>" +
                        (isCustomer?
                "<th><a href=/insertAddress?isSendAddress=false>添加..</a></th><th><a>烫烫烫</a></th>":"")
                        +"</tr>";
        int cntsend = 1, cntreceive = 1;
        for(Commonaddress item : send){
            String tmp = "<tr>";
            tmp += "<td>" + (cntsend++) + "</td>";
            tmp += "<td>" + item.getTargetUser() + "</td>";
            tmp += "<td id=\"address\">" + item.getAddress() + "</td>";
            if(isCustomer) {
                tmp += "<td><a href=/changeAddress?ID=" + String.valueOf(item.getId()) + ">编辑</a></td>";
                tmp += "<td><a href=/deleteAddress?ID=" + item.getId() + ">删除</a></td>";
            }
            tmp += "</tr>";
            sendHTML += tmp;
        }
        sendHTML += "</table>";
        for(Commonaddress item : receive){
            String tmp = "<tr>";
            tmp += "<td>" + (cntreceive++) + "</td>";
            tmp += "<td>" + item.getTargetUser() + "</td>";
            tmp += "<td id=\"address\">" + item.getAddress() + "</td>";
            if(isCustomer) {
                tmp += "<td><a href=/changeAddress?ID=" + String.valueOf(item.getId()) + ">编辑</a></td>";
                tmp += "<td><a href=/deleteAddress?ID=" + item.getId() + ">删除</a></td>";
            }
            tmp += "</tr>";
            receiveHTML += tmp;
        }
        receiveHTML += "</table>";
        List<String> ret = new ArrayList<>();
        ret.add(sendHTML);
        ret.add(receiveHTML);
        return ret;
    }
    public static String ExpressOrderToHTML(List<Expressorder> list){
        String ans="<table border =\"1\"><tr><th>订单编号</th><th>发出地</th>" +
                "<th>发件人</th><th>收件地址</th><th>收件人</th><th>订单日期</th><th>订单金额</th>" +
                "<th>运送情况</th></tr>";
        Iterator<Expressorder> iterator = list.iterator();
        while(iterator.hasNext()) {
            Expressorder expressorder = iterator.next();
            ans += "<tr>";
            ans += "<td>" + expressorder.getOrderNo() + "</td>";
            ans += "<td>" + expressorder.getSentAddress() + "</td>";
            ans += "<td>" + expressorder.getExpressOrderByCustomer().getName() + "</td>";
            ans += "<td>" + expressorder.getReceiveAddress()+"</td>";
            ans += "<td>" + expressorder.getReceiverName()+"</td>";
            ans += "<td>" + expressorder.getOrderDate()+"</td>";
            ans += "<td>" + expressorder.getPayment()+"</td>";
            ans += "<td><a href=\"deliveryDetail?orderID=" + expressorder.getOrderNo() + "\">详情..</a></td>";
            ans += "</tr>";
        }
        // ans = ans + "<a href='product?id=" + product.getProductId() + "'>查看商品详情</a><br>";
        ans += "</table>";
        return ans;
    }
}
