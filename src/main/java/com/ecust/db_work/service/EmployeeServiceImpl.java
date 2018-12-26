package com.ecust.db_work.service;

import com.ecust.db_work.entity.Employee;
import com.ecust.db_work.repository.EmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepositoryImpl employeeRepository;
    public List<Employee> getAllEmployee() {
        return employeeRepository.findByName("");
    }
}
