package com.ecust.db_work.service;

import com.ecust.db_work.entity.Customer;
import com.ecust.db_work.repository.CustomerRepositoryImpl;
import com.ecust.db_work.repository.EmployeeRepositoryImpl;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private EmployeeRepositoryImpl employeeRepository;

    @Autowired
    private CustomerRepositoryImpl customerRepository;

    public Customer findCustomerByName(String name){
        return customerRepository.findByName(name);
    }

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }
}
