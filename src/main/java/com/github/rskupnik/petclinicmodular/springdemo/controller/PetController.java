package com.github.rskupnik.petclinicmodular.springdemo.controller;

import com.github.rskupnik.petclinicmodular.service.PetService;
import com.github.rskupnik.petclinicmodular.springdemo.dto.PetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.CollectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController("/pets")
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
