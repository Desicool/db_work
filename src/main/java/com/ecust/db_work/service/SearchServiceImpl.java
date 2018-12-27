package com.ecust.db_work.service;

import com.ecust.db_work.entity.Customer;
import com.ecust.db_work.entity.Station;
import com.ecust.db_work.repository.CustomerRepositoryImpl;
import com.ecust.db_work.repository.EmployeeRepositoryImpl;
import com.ecust.db_work.repository.StationRepository;
import com.ecust.db_work.repository.StationRepositoryImpl;
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

    @Autowired
    private StationRepositoryImpl stationRepository;

    @Override
    public Customer findCustomerByName(String name){
        return customerRepository.findByName(name);
    }

    @Override
    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }

    @Override
    public List<Station> findStation(String str, boolean byName) {
        String name = "%" + str + "%";
        String address = "%" + str + "%";
        if(byName)
            return stationRepository.findByName(name);
        else
            return stationRepository.findByAddress(address);
    }
}
