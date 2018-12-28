package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Commonaddress;

public interface CommonAddressRepository extends baseRepository<Commonaddress,Integer> {
    void update(Commonaddress commonaddress);
}
