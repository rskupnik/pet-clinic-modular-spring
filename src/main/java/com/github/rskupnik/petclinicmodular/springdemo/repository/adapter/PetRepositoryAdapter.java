package com.github.rskupnik.petclinicmodular.springdemo.repository.adapter;

import com.github.rskupnik.petclinicmodular.application.pet.repository.api.PetRepository;
import com.github.rskupnik.petclinicmodular.domain.pet.Pet;
import com.github.rskupnik.petclinicmodular.springdemo.repository.PetRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetRepositoryAdapter implements PetRepository {

    private final PetRepositoryJpa repository;

    @Autowired
    public PetRepositoryAdapter(PetRepositoryJpa repository) {
        this.repository = repository;
    }

    @Override
    public List<Pet> getAll() {
        final List<Pet> output = new ArrayList<>();
        repository.findAll().forEach(output::add);
        return output;
    }

    @Override
    public Pet get(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void add(Pet pet) {
        repository.save(pet);
    }
}
