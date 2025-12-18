package com.codeline.ccsb.Services;

import com.codeline.ccsb.Entity.Course;
import com.codeline.ccsb.Entity.Instructor;
import com.codeline.ccsb.Entity.PhoneNumber;
import com.codeline.ccsb.Entity.Student;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.PhoneNumberRepository;
import com.codeline.ccsb.repositories.StudentRepository;
import com.codeline.ccsb.requestObject.CourseCreateRequest;
import com.codeline.ccsb.requestObject.PhoneNumberCreateRequest;
import com.codeline.ccsb.responseObjects.PhoneNumberCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PhoneNumberServices {

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<PhoneNumber> getAllPhoneNumbers() throws Exception {
        return phoneNumberRepository.findAll();
    }

    public PhoneNumberCreateResponse savePhoneNumber(PhoneNumberCreateRequest request) throws Exception {
        PhoneNumber phoneNumber = PhoneNumberCreateRequest.converToPhoneNumber(request);
        phoneNumber.setCreatedDate(new Date());
        phoneNumber.setIsActive(Boolean.TRUE);

        return PhoneNumberCreateResponse.convertToPhoneNumberResponse(phoneNumberRepository.save(phoneNumber));
    }

    public PhoneNumber updatePhoneNumber(PhoneNumber phoneNumber) throws Exception {
        PhoneNumber existingPhoneNumber = phoneNumberRepository.findById(phoneNumber.getId()).get();
        if (existingPhoneNumber != null && existingPhoneNumber.getIsActive()) {
            phoneNumber.setUpdatedDate(new Date());
            return phoneNumberRepository.save(phoneNumber);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public void deletePhoneNumber(Integer id) throws Exception {
        PhoneNumber existingPhoneNumber = phoneNumberRepository.findById(id).get();
        if (existingPhoneNumber != null && existingPhoneNumber.getIsActive()) {
            existingPhoneNumber.setUpdatedDate(new Date());
            existingPhoneNumber.setIsActive(Boolean.FALSE);
            phoneNumberRepository.save(existingPhoneNumber);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public PhoneNumber getPhoneNumberById(Integer id) throws Exception {
        PhoneNumber existingPhoneNumber = phoneNumberRepository.findById(id).get();
        if (existingPhoneNumber != null && existingPhoneNumber.getIsActive()) {
            return existingPhoneNumber;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

}


