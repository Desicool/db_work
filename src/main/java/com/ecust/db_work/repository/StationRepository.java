package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Station;

import java.util.List;

public interface StationRepository extends baseRepository<Station,String> {
    List<Station> findByName(String name);
    List<Station> findByAddress(String address);
}
