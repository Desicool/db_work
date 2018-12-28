package com.ecust.db_work.utils;

import com.ecust.db_work.entity.Employee;
import com.ecust.db_work.entity.Payroll;
import com.ecust.db_work.entity.Payrolldetail;

import java.util.Iterator;
import java.util.List;

public class EmployeeUtil {

    public static String EmployeeToHTML(List<Employee> list)
    {

        Iterator<Employee> iterator = list.iterator();
        String ans = "";
        if(iterator.hasNext())
            ans ="<table border =\"1\"><tr><th>编号</th><th>姓名</th><th>性别</th>" +
                "<th>年龄</th><th>工作站点</th><th>职位</th><th>工资</th></tr>";
        else
            return ans;
        while(iterator.hasNext()) {
            Employee employee = iterator.next();
            ans += "<tr>";
            ans += "<td>"+employee.getEmployeeId()+"</td>";
            ans += "<td>"+employee.getName()+"</td>";
            ans += "<td>"+employee.getSex()+"</td>";
            ans += "<td>"+employee.getBirthday()+"</td>";
            ans += "<td>" + employee.getStationByStationID().getName() + "</td>";
            ans += "<td>"+employee.getJob()+"</td>";
            ans += "<td><a href=\"/showPayroll?employeeID=" + employee.getEmployeeId() + "\">详情..</a></td>";
            ans += "</tr>";
        }
        ans += "</table>";
        return ans;
    }

    public static String PayrollToHTML(List<Payroll> list){
        String ans="<table border =\"1\"><tr><th>工资单编号</th><th>员工姓名</th>" +
                "<th>发放时间</th><th>发放金额</th><th>详情</th></tr>";

        Iterator<Payroll> iterator = list.iterator();
        while(iterator.hasNext()) {
            Payroll payroll = iterator.next();
            ans += "<tr>";
            ans += "<td>"+payroll.getPayrollId()+"</td>";
            ans += "<td>"+payroll.getEmployeeByEmployeeId().getName()+"</td>";
            ans += "<td>"+payroll.getPayTime()+"</td>";
            double tmp = 0;
            for(Payrolldetail payrolldetail : payroll.getPayrollDetailByPayrollId()){
                tmp += payrolldetail.getMoney();
            }
            ans += "<td>" + tmp + "</td>";
            ans += "<td><a href=\"showPayrollDetail?payrollID=" + payroll.getPayrollId() + "\">详情..</a></td>";
            ans += "</tr>";
        }
        ans += "</table>";
        return ans;
    }

    public static String PayrollDetailToHTML(List<Payrolldetail> list){
        String ans="<table border =\"1\"><tr><th>工资单编号</th><th>类型</th>" +
                "<th>金额</th></tr>";

        Iterator<Payrolldetail> iterator = list.iterator();
        while(iterator.hasNext()) {
            Payrolldetail payrolldetail = iterator.next();
            ans += "<tr>";
            ans += "<td>"+payrolldetail.getPayrollByPayrollId().getPayrollId()+"</td>";
            ans += "<td>"+payrolldetail.getType()+"</td>";
            ans += "<td>"+payrolldetail.getMoney()+"</td>";
            ans += "</tr>";
        }
        ans += "</table>";
        return ans;
    }
}
