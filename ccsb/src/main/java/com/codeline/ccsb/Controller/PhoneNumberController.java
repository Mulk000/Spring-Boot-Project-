package com.codeline.ccsb.Controller;


import com.codeline.ccsb.Entity.PhoneNumber;
import com.codeline.ccsb.Services.PhoneNumberServices;
import com.codeline.ccsb.requestObject.PhoneNumberCreateRequest;
import com.codeline.ccsb.responseObjects.PhoneNumberCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/phoneNumber")
public class PhoneNumberController {

    @Autowired
    PhoneNumberServices phoneNumberServices;

    @PostMapping("create")
    public PhoneNumberCreateResponse createPhoneNumber(@RequestBody PhoneNumberCreateRequest requestedObj) throws Exception {
        PhoneNumberCreateRequest.validCreatesPhoneNumberRequestObject(requestedObj);
        return phoneNumberServices.savePhoneNumber(requestedObj);

    }
    @GetMapping("getAll")
    public List<PhoneNumber> getAllPhonNumber() throws Exception {
        List<PhoneNumber> phoneNumberList=phoneNumberServices.getAllPhoneNumbers();
        return phoneNumberList;
    }

    @GetMapping("getById")
    public PhoneNumber grtPhoneNumberById(@RequestParam int id)throws Exception {
        return phoneNumberServices.getPhoneNumberById(id);
    }

    @PutMapping("update")
    public PhoneNumber updatePhoneNumber(@RequestBody PhoneNumber updateObjectFromUser) throws Exception {
        return phoneNumberServices.updatePhoneNumber(updateObjectFromUser);


    }
    @DeleteMapping("delete/{id}")
    public String deletePhoneNumber(@PathVariable int id) throws Exception {
        phoneNumberServices.deletePhoneNumber(id);
        return "Success";

    }
}
