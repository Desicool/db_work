package com.ecust.db_work.service;

import com.ecust.db_work.entity.*;
import com.ecust.db_work.repository.EmployeeRepositoryImpl;
import com.ecust.db_work.repository.PayrollRepository;
import com.ecust.db_work.repository.PayrollRepositoryImpl;
import com.ecust.db_work.repository.StationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepositoryImpl employeeRepository;
    @Autowired
    private PayrollRepositoryImpl payrollRepository;
    @Autowired
    private StationRepositoryImpl stationRepository;
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findByName("");
    }

    @Override
    public List<Payroll> getPayrollByEmployeeId(String employeeID) {
        Employee employee = employeeRepository.findByEmployeeID(employeeID);
        return payrollRepository.findByEmployee(employee);
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeeByStation(String staionName) {
        List<Station> list = stationRepository.findByName(staionName);
        List<String> tmp = new ArrayList<>();
        for(Station station : list){
            tmp.add(station.getStationId());
        }
        return employeeRepository.findByStatinID(tmp);
    }

    @Override
    public List<Payrolldetail> getPayrollDetailByPayrollID(String payrollID){
        return payrollRepository.findByPayrollID(payrollID).getPayrollDetailByPayrollId();
    }
}
