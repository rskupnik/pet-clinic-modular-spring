package com.github.rskupnik.petclinicmodular.springdemo.repository;

import com.github.rskupnik.petclinicmodular.domain.pet.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepositoryJpa extends CrudRepository<Pet, Long> {
}
