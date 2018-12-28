package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends baseRepository<Employee,String> {
    List<Employee> findByName(String name);
    Employee findByEmployeeID(String employeeID);
    List<Employee> findByStatinID(List<String> stationID);
}
