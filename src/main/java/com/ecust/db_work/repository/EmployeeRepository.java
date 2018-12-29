package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Employee;
import com.ecust.db_work.entity.Station;

import java.util.List;

public interface EmployeeRepository extends baseRepository<Employee,String> {
    List<Employee> findByName(String name);
    Employee findByEmployeeID(String employeeID);
    List<Employee> findByStatin(List<Station> station);
}
