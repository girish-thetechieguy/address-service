package com.techstarters.address.service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CustomerAddressList {
    private List<CustomerAddress> customerAddress;

    public CustomerAddressList(List<CustomerAddress> customerAddress) {
        this.customerAddress = customerAddress;
    }
}
