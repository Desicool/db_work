package com.ecust.db_work.service;

import com.ecust.db_work.entity.Commonaddress;

import java.util.List;

public interface CustomerService {
    List<Commonaddress> getCommonAddress(String customerName);
}
