package com.example.animal_gallery.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of Animals objects.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Animal>> getAllAnimals() {
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.OK);
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/2
     *
     * @param animalId the unique Id for an Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable int animalId) {
        return new ResponseEntity<>(service.getAnimalById(animalId), HttpStatus.OK);
    }

    /**
     * Get a list of Animals based on their species.
     * http://localhost:8080/animals/species/cat
     *
     * @param species the search key.
     * @return A list of Animals objects matching the search key.
     */
    @GetMapping("/species/{species}")
    public ResponseEntity<List<Animal>> getAnimalsBySpecies(@PathVariable String species) {
        return new ResponseEntity<>(service.getAnimalsBySpecies(species), HttpStatus.OK);
    }

    /**
     * Get a list of animals with a name that contains the given string.
     * http://localhost:8080/animals/name?search=A
     *
     * @param search the search key
     * @return list of Animals objects matching the search key.
     */
    @GetMapping("/name")
    public ResponseEntity<List<Animal>> getAnimalsByName(@RequestParam String search) {
        return new ResponseEntity<>(service.getAnimalsByName(search), HttpStatus.OK);
    }

    /**
     * Create a new Animal entry.
     * http://localhost:8080/animals/new
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public ResponseEntity<List<Animal>> addNewAnimal(@RequestBody Animal animal) {
        service.addAnimal(animal);
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.CREATED);
    }

    /**
     * Update an existing Animals object.
     * http://localhost:8080/animals/update/2
     *
     * @param animalId the unique Animal Id.
     * @param animal the new update details.
     * @return the updated Student object.
     */
    @PutMapping("/update/{animalId}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return new ResponseEntity<>(service.getAnimalById(animalId), HttpStatus.OK);
    }

    /**
     * Delete a Student object.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{animalId}")
    public ResponseEntity<List<Animal>> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.OK);
    }
}
