package com.ecust.db_work.utils;

import com.ecust.db_work.entity.Employee;

import java.util.Iterator;
import java.util.List;

public class EmployeeUtil {

    public static String EmployeeToHTML(List<Employee> list)
    {
        String ans="<table border =\"1\"><tr><th>编号</th><th>姓名</th><th>性别</th><th>年龄</th><th>职位</th></tr>";

        Iterator<Employee> iterator = list.iterator();
        while(iterator.hasNext()) {
            Employee employee = iterator.next();
            ans += "<tr>";
            ans += "<td>"+employee.getEmployeeId()+"</td>";
            ans += "<td>"+employee.getName()+"</td>";
            ans += "<td>"+employee.getSex()+"</td>";
            ans += "<td>"+employee.getBirthday()+"</td>";
            ans += "<td>"+employee.getJob()+"</td>";
            ans += "</tr>";
           // ans = ans + "<a href='product?id=" + product.getProductId() + "'>查看商品详情</a><br>";
        }
        ans += "</table>";
        return ans;
    }
}
