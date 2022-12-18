package com.techstarters.address.service.service;

import com.techstarters.address.service.entity.CustomerAddress;
import com.techstarters.address.service.entity.CustomerAddressList;
import com.techstarters.address.service.repository.CustomerAddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerAddressService {

    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    public CustomerAddress createAddress(CustomerAddress customerAddress) {
        log.info("Inside CustomerAddressService and method createAddress()");
        return  customerAddressRepository.save(customerAddress);
    }

    public CustomerAddress getCustomerAddressById(Long customerAddressId) {
        log.info("Inside CustomerAddressService and method getCustomerAddressById()");
        return customerAddressRepository.findByAddressId(customerAddressId);
    }

    public List<CustomerAddress> getCustomerAddressByCustomerId(Long customerId) {
        log.info("Inside CustomerAddressService and method getCustomerAddressByCustomerId()");
        List<CustomerAddress> customerAddressList = customerAddressRepository.findAllByCustomerId(customerId);
        return customerAddressList;
    }
}
