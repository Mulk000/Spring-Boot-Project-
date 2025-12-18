package com.codeline.ccsb.Controller;

import com.codeline.ccsb.Entity.Address;
import com.codeline.ccsb.Services.AddressServices;
import com.codeline.ccsb.requestObject.AddressCreateRequest;
import com.codeline.ccsb.responseObjects.AddressCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressServices addressServices;

    @PostMapping("create")
    public AddressCreateResponse createAddress(@RequestBody AddressCreateRequest requestedObj) throws Exception {
        AddressCreateRequest.validCreatesAddressRequestObject(requestedObj);
        return addressServices.saveAddress(requestedObj);

    }

    @PutMapping("update")
    public Address updateAddress(@RequestBody Address updatedObjFromUser) throws Exception {
        return addressServices.updateAddress(updatedObjFromUser);
    }

}
