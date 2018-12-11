package com.github.rskupnik.petclinicmodular.springdemo.repository.adapter;

import com.github.rskupnik.petclinicmodular.application.customer.repository.api.CustomerRepository;
import com.github.rskupnik.petclinicmodular.domain.customer.Customer;
import com.github.rskupnik.petclinicmodular.springdemo.repository.CustomerRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerRepositoryJPA repository;

    @Autowired
    public CustomerRepositoryAdapter(CustomerRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> getAll() {
        final List<Customer> output = new ArrayList<>();
        repository.findAll().forEach(output::add);
        return output;
    }

    @Override
    public Customer get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void add(Customer customer) {
        repository.save(customer);
    }
}
