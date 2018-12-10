package com.github.rskupnik.petclinicmodular.springdemo.dto;

import com.github.rskupnik.petclinicmodular.domain.customer.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerDto {

    private String firstName, lastName;
    private List<PetDto> pets;

    public CustomerDto() {

    }

    private CustomerDto(String firstName, String lastName, List<PetDto> pets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pets = pets;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<PetDto> getPets() {
        return pets;
    }

    public void setPets(List<PetDto> pets) {
        this.pets = pets;
    }

    public static CustomerDto fromDomain(Customer customer) {
        return new CustomerDto(customer.getFirstName(), customer.getLastName(), customer.getPets() != null ? customer.getPets().stream().map(PetDto::fromDomain).collect(Collectors.toList()) : null);
    }

    public Customer toDomain() {
        return new Customer(firstName, lastName, pets != null ? pets.stream().map(PetDto::toDomain).collect(Collectors.toList()) : null);
    }
}
