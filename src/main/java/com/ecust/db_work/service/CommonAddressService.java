package com.ecust.db_work.service;

import com.ecust.db_work.entity.Commonaddress;

public interface CommonAddressService {
    Commonaddress findByID(int ID);
    Integer updateCommonAddress(String address,String user,String id);
}
