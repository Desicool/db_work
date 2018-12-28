package com.ecust.db_work.service;

import com.ecust.db_work.entity.Commonaddress;
import com.ecust.db_work.repository.CommonAddressRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonAddressServiceImpl implements CommonAddressService{
    @Autowired
    private CommonAddressRepositoryImpl commonAddressRepository;
    @Override
    public Commonaddress findByID(int ID) {
        return commonAddressRepository.get(ID);
    }

    @Override
    public Integer updateCommonAddress(String address, String user, String id) {
        Commonaddress commonaddress = commonAddressRepository.get(Integer.valueOf(id).intValue());
        boolean ok = false;
        if(!address.equals(commonaddress.getAddress())){
            commonaddress.setAddress(address);
            ok = true;
        }
        if(!user.equals(commonaddress.getTargetUser())) {
            commonaddress.setTargetUser(user);
            ok = true;
        }
        if(ok) {
            commonAddressRepository.update(commonaddress);
            commonAddressRepository.flush();
        }
        return commonaddress.getId();
    }
}
