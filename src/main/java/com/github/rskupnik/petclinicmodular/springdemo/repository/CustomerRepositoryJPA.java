package com.github.rskupnik.petclinicmodular.springdemo.repository;

import com.github.rskupnik.petclinicmodular.domain.customer.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositoryJPA extends CrudRepository<Customer, Long> {
}
