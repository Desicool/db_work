package com.ecust.db_work.utils;

import com.ecust.db_work.entity.Customer;
import com.ecust.db_work.entity.Employee;

import java.util.Iterator;
import java.util.List;

public class CustomerUtil {
    public static String CustomerToHTML(Customer customer)
    {
        String ans="<table border =\"1\"><tr><th>编号</th><th>姓名</th><th>性别</th><th>..</th></tr>";
        ans += "<tr>";
        ans += "<td>" + customer.getCustomerId()+"</td>";
        ans += "<td>" + customer.getName()+"</td>";
        ans += "<td>" + customer.getSex()+"</td>";
        ans += "<td><a href=\"/customerDetail.jmp\" name=customerID value=\""+customer.getCustomerId()+"\">详细信息</a></td>";
        ans += "</tr>";
            // ans = ans + "<a href='product?id=" + product.getProductId() + "'>查看商品详情</a><br>";
        ans += "</table>";
        return ans;
    }
    public static String CustomerListToHTML(List<Customer> list)
    {
        String ans="<table border =\"1\"><tr><th>编号</th><th>姓名</th><th>性别</th><th>..</th></tr>";
        Iterator<Customer> iterator = list.iterator();
        while(iterator.hasNext()) {
            Customer customer = iterator.next();
            ans += "<tr>";
            ans += "<td>" + customer.getCustomerId() + "</td>";
            ans += "<td>" + customer.getName() + "</td>";
            ans += "<td>" + customer.getSex() + "</td>";
            ans += "<td><a href=\"/customerDetail.jmp\" name=customerID value=\""+customer.getCustomerId()+"\">详细信息</a></td>";
            ans += "</tr>";
        }
        // ans = ans + "<a href='product?id=" + product.getProductId() + "'>查看商品详情</a><br>";
        ans += "</table>";
        return ans;
    }
}
