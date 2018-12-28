package com.ecust.db_work.service;

import com.ecust.db_work.entity.Employee;
import com.ecust.db_work.entity.Payroll;
import com.ecust.db_work.entity.Payrolldetail;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    List<Payroll> getPayrollByEmployeeId(String employeeID);
    List<Employee> getEmployeeByName(String name);
    List<Employee> getEmployeeByStation(String staionName);
    List<Payrolldetail> getPayrollDetailByPayrollID(String payrollID);
}
