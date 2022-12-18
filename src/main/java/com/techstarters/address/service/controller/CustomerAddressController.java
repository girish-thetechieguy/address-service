package com.techstarters.address.service.controller;

import com.techstarters.address.service.entity.CustomerAddress;
import com.techstarters.address.service.entity.CustomerAddressList;
import com.techstarters.address.service.service.CustomerAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
@Slf4j
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService customerAddressService;

    @PostMapping("/create")
    public CustomerAddress createAddressForCustomer(@RequestBody CustomerAddress customerAddress){
        log.info("Inside CustomerAddressController and method createAddressForCustomer()");
        return customerAddressService.createAddress(customerAddress);
    }

    @GetMapping("/{id}")
    public CustomerAddress getCustomerAddressById(@PathVariable("id") Long customerAddressId) {
        log.info("Inside CustomerAddressController and method getCustomerAddressById()");
        return customerAddressService.getCustomerAddressById(customerAddressId);
    }

    @GetMapping("/customer/{id}")
    public CustomerAddressList getCustomerAddressByCustomerId(@PathVariable("id") Long customerId) {
        log.info("Inside CustomerAddressController and method getCustomerAddressByCustomerId()");
        List<CustomerAddress> addressList = customerAddressService.getCustomerAddressByCustomerId(customerId);
        CustomerAddressList customerAddressList = new CustomerAddressList();
        customerAddressList.setCustomerAddress(addressList);
        return customerAddressList;
    }


}
