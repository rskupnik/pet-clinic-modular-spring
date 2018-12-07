package com.github.rskupnik.petclinicmodular.springdemo.config;

import com.github.rskupnik.petclinicmodular.pet.repository.PetRepository;
import com.github.rskupnik.petclinicmodular.pet.repository.defaultimpl.DefaultPetRepository;
import com.github.rskupnik.petclinicmodular.service.PetService;
import com.github.rskupnik.petclinicmodular.service.defaultimpl.DefaultPetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeansConfig {

    @Bean
    public PetRepository petRepository() {
        return new DefaultPetRepository();
    }

    @Bean
    public PetService petService(PetRepository petRepository) {
        return new DefaultPetService(petRepository);
    }
}
