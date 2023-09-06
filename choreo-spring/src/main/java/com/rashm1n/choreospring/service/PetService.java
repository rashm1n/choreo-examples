package com.rashm1n.choreospring.service;

import com.rashm1n.choreospring.model.Pet;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PetService {
    private int id = 0;
    private List<Pet> petList = new LinkedList<>();

    public Pet addPet(Pet pet) {
        pet.setId(++id);
        petList.add(pet);
        return pet;
    }

    public Pet getPet(Integer id) {
        return petList.stream().filter(pet -> pet.getId() == id).findFirst().orElse(null);
    }

    public List<Pet> getAllPets() {
        return petList;
    }

    public void updatePet(int id, Pet pet) {
        Pet petToUpdate = getPet(id);
        petToUpdate.setName(pet.getName());
        petToUpdate.setPetType(pet.getPetType());
        petToUpdate.setColor(pet.getColor());
        petToUpdate.setAge(pet.getAge());
    }

    public void deletePet(int id) {
        petList.removeIf(pet -> pet.getId() == id);
    }
}
