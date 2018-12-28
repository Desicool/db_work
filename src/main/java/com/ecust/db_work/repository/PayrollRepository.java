package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Employee;
import com.ecust.db_work.entity.Payroll;

import java.util.List;

public interface PayrollRepository extends baseRepository<Payroll,String> {
    List<Payroll> findByEmployee(Employee employee);
    Payroll findByPayrollID(String payrollID);
}
