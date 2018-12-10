package com.github.rskupnik.petclinicmodular.springdemo.dto;

import com.github.rskupnik.petclinicmodular.domain.customer.Customer;

public class CustomerDto {

    private String firstName, lastName;

    public CustomerDto() {

    }

    private CustomerDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public static CustomerDto fromDomain(Customer customer) {
        return new CustomerDto(customer.getFirstName(), customer.getLastName());
    }

    public Customer toDomain() {
        return new Customer(firstName, lastName);
    }
}
