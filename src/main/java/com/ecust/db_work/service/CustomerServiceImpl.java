package com.ecust.db_work.service;

import com.ecust.db_work.entity.Commonaddress;
import com.ecust.db_work.entity.Customer;
import com.ecust.db_work.repository.CommonAddressRepositoryImpl;
import com.ecust.db_work.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepositoryImpl customerRepository;
    @Autowired
    private CommonAddressRepositoryImpl commonAddressRepository;

    @Override
    public List<Commonaddress> getCommonAddress(String customerID) {
        return commonAddressRepository.findByCustomerID(customerID);
    }
}
