package com.github.rskupnik.petclinicmodular.springdemo.config;

import com.github.rskupnik.petclinicmodular.application.customer.repository.api.CustomerRepository;
import com.github.rskupnik.petclinicmodular.application.customer.service.api.CustomerService;
import com.github.rskupnik.petclinicmodular.application.pet.repository.api.PetRepository;
import com.github.rskupnik.petclinicmodular.application.pet.service.api.PetService;
import com.github.rskupnik.petclinicmodular.springdemo.repository.CustomerRepositoryJPA;
import com.github.rskupnik.petclinicmodular.springdemo.repository.PetRepositoryJpa;
import com.github.rskupnik.petclinicmodular.springdemo.repository.adapter.CustomerRepositoryAdapter;
import com.github.rskupnik.petclinicmodular.springdemo.repository.adapter.PetRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImplementationConfig {

    @Bean
    public PetRepository petRepository(PetRepositoryJpa jpaRepo) {
        return new PetRepositoryAdapter(jpaRepo);
    }

    @Bean
    public PetService petService(PetRepository petRepository) {
        return PetService.defaultService(petRepository);
    }

    @Bean
    public CustomerRepository customerRepository(CustomerRepositoryJPA jpaRepo) {
        return new CustomerRepositoryAdapter(jpaRepo);
    }

    @Bean
    public CustomerService customerService(CustomerRepository customerRepository, PetService petService) {
        return CustomerService.defaultService(customerRepository, petService);
    }
}
