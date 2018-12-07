package com.github.rskupnik.petclinicmodular.springdemo.dto;

import com.github.rskupnik.petclinicmodular.pet.domain.Pet;

public class PetDto {

    private String name;

    public PetDto() {

    }

    private PetDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static PetDto fromDomain(Pet pet) {
        return new PetDto(pet.getName());
    }

    public Pet toDomain() {
        return new Pet(name);
    }
}
