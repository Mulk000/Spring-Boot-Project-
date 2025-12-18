package com.codeline.ccsb.Services;

import com.codeline.ccsb.Entity.Address;
import com.codeline.ccsb.Entity.Student;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.AddressRepository;
import com.codeline.ccsb.repositories.StudentRepository;
import com.codeline.ccsb.requestObject.AddressCreateRequest;
import com.codeline.ccsb.responseObjects.AddressCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddressServices {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    StudentRepository studentRepository;


    public AddressCreateResponse saveAddress(AddressCreateRequest request) throws Exception {
        Address address = AddressCreateRequest.convertToAddress(request);
        address.setCreatedDate(new Date());
        address.setIsActive(Boolean.TRUE);
        return AddressCreateResponse.convertToAddressResponse(addressRepository.save(address));
    }

    public Address updateAddress(Address address) throws Exception {
        Address existingAddress = addressRepository.findById(address.getId()).get();
        if (existingAddress != null && existingAddress.getIsActive()) {
            existingAddress.setUpdatedDate(new Date());
           return addressRepository.save(existingAddress);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
}
