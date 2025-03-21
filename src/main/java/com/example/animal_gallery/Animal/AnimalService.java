package com.example.animal_gallery.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AnimalService.java
 * Centralizes data access to the Animal Database.
 */

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    /**
     * Fetch all Animals.
     *
     * @return the list of all Animals.
     */
    public List<Animal> getAllAnimals(){
        return animalRepository.findAll();
    }

    public Animal getAnimalById(int animalId){
        return animalRepository.findById(animalId).orElse(null);
    }

    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.getAnimalBySpecies(species);
    }

    public List<Animal> getAnimalsByName(String name) {
        return animalRepository.getAnimalByName(name);
    }

    public List<Animal> getOlderAnimals(double age) {
        return animalRepository.getOlderAnimals(age);
    }

    public void addAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void updateAnimal(int animalId, Animal updatedAnimal) {
        Animal existing = getAnimalById(animalId);
        existing.setName(updatedAnimal.getName());
        existing.setDescription(updatedAnimal.getDescription());
        existing.setSpecies(updatedAnimal.getSpecies());
        existing.setAge(updatedAnimal.getAge());
        existing.setActiveDate(updatedAnimal.getActiveDate());

        animalRepository.save(existing);
    }

    public void deleteAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }

}
