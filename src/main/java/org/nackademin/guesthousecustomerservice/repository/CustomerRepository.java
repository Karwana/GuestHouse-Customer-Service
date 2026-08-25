package org.nackademin.guesthousecustomerservice.repository;

import org.nackademin.guesthousecustomerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
}