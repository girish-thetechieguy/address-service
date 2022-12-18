package com.techstarters.address.service.repository;

import com.techstarters.address.service.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {
    CustomerAddress findByAddressId(Long customerAddressId);

    List<CustomerAddress> findAllByCustomerId(Long customerId);
}
