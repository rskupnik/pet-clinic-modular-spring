package com.github.rskupnik.petclinicmodular.springdemo.controller;

import com.github.rskupnik.petclinicmodular.application.pet.service.api.PetService;
import com.github.rskupnik.petclinicmodular.springdemo.dto.PetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<PetDto> getAll() {
        return petService.getAll().stream().map(PetDto::fromDomain).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void add(@RequestBody PetDto pet) {
        petService.add(pet.toDomain());
    }
}
