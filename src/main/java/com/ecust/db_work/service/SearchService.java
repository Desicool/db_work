package com.ecust.db_work.service;

import com.ecust.db_work.entity.Customer;

import java.util.List;

public interface SearchService {
    Customer findCustomerByName(String name);
    List<Customer> findAllCustomer();
}
