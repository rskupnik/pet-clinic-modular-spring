package com.github.rskupnik.petclinicmodular.springdemo.controller;

import com.github.rskupnik.petclinicmodular.application.customer.service.api.CustomerService;
import com.github.rskupnik.petclinicmodular.application.pet.service.api.PetService;
import com.github.rskupnik.petclinicmodular.springdemo.dto.CustomerDto;
import com.github.rskupnik.petclinicmodular.springdemo.dto.PetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final PetService petService;

    @Autowired
    public CustomerController(CustomerService customerService, PetService petService) {
        this.customerService = customerService;
        this.petService = petService;
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
    public void add(@RequestBody CustomerDto customer) {
        if (customer.getPets() != null && !customer.getPets().isEmpty()) {
            for (PetDto pet : customer.getPets()) {
                petService.add(pet.toDomain());
            }
        }

        customerService.add(customer.toDomain());
    }
}
