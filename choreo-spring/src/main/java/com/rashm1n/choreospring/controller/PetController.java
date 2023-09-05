package com.rashm1n.choreospring.controller;

import com.rashm1n.choreospring.model.Pet;
import com.rashm1n.choreospring.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    public PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable int id) {
        return ResponseEntity.ok(petService.getPet(id));
    }

    @PostMapping
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        petService.addPet(pet);
        return ResponseEntity.ok(pet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable int id, @RequestBody Pet pet) {
        petService.updatePet(id, pet);
        return ResponseEntity.ok(pet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable int id) {
        petService.deletePet(id);
        return ResponseEntity.ok().build();
    }
}
