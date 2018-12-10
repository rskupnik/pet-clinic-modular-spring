package com.github.rskupnik.petclinicmodular.springdemo.controller;

import com.github.rskupnik.petclinicmodular.application.customer.service.api.CustomerService;
import com.github.rskupnik.petclinicmodular.springdemo.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = "application/json")
    public CustomerDto get(@PathVariable Long id) {
        return CustomerDto.fromDomain(customerService.get(id));
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<CustomerDto> getAll() {
        return customerService.getAll().stream().map(CustomerDto::fromDomain).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void add(CustomerDto customer) {
        customerService.add(customer.toDomain());
    }
}
