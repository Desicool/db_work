package com.ecust.db_work.service;

import com.ecust.db_work.entity.Commonaddress;
import com.ecust.db_work.entity.Expressorder;

import java.util.List;

public interface CustomerService {
    List<Commonaddress> getCommonAddress(String customerName);
    List<Expressorder> getExpressOrder(String customerID);
    void deleteCommonAddress(int ID);
}
