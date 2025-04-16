package com.example.animal_gallery.Animal;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */
//@RestController
@Controller
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
    public Object getAllAnimals(Model model) {
        List<Animal> animals = service.getAllAnimals();
        for (Animal animal : animals) {
            if (animal.getImage() == null) {
                animal.setImage("");
            }
        }
        model.addAttribute("animalList", animals);
        model.addAttribute("title", "All Animals");
        return "animal-list";
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/2
     *
     * @param animalId the unique Id for an Animal.
     * @return One Animal object.
     */
    @GetMapping("/details/{animalId}")
    public String getAnimalById(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId));
        model.addAttribute("title", "Animal Details");
        return "animal-details";
    }

//    @GetMapping("/{animalId}")
//    public Object getAnimalById(@PathVariable int animalId, Model model){
//        model.addAttribute("animal", service.getAnimalById(animalId));
//        model.addAttribute("title", "Animal #: " + animalId);
//        return "animal-details";
//    }
//    public ResponseEntity<Animal> getAnimalById(@PathVariable int animalId) {
//        return new ResponseEntity<>(service.getAnimalById(animalId), HttpStatus.OK);
//    }

    /**
     * Get a list of animals with a name that contains the given string.
     * http://localhost:8080/animals/name?search=A
     *
     * @param search the search key
     * @return list of Animals objects matching the search key.
     */
    @GetMapping("/name")
    public Object getAnimalsByName(@RequestParam(name = "search", defaultValue = "") String search, Model model) {
        List<Animal> animals = service.getAnimalsByName(search);
        if (animals.isEmpty()) {
            model.addAttribute("error", "No animals found with the name: " + search);
        }
        model.addAttribute("animalList", animals);
        model.addAttribute("title", "Animals By Name: " + search);
        return "animal-list";
    }
//    @GetMapping("/name")
//    public Object getAnimalsByName(@RequestParam(name = "search", defaultValue = "") String search, Model model){
//        model.addAttribute("animalList", service.getAnimalsByName(search));
//        model.addAttribute("title", "Animals By Name: " + search);
//        return "animal-list";
//    }

    /**
     * Get a list of Animals based on their species.
     * http://localhost:8080/animals/species/cat
     *
     * @param species the search key.
     * @return A list of Animals objects matching the search key.
     */
    @GetMapping("/species/{species}")
    public Object getAnimalsBySpecies(@PathVariable String species, Model model){
        model.addAttribute("animalList", service.getAnimalsBySpecies(species));
        model.addAttribute("title", "Animals By Species: " + species);
        return "animal-list";
    }

    /**
     * Show the view for a new Animal Form.
     *
     * @param model
     * @return the form view
     */
    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        Animal animal = new Animal();
        model.addAttribute("animal", animal);
        model.addAttribute("title", "Create New Animal");
        return "animal-create";
    }
    /**
     * Create a new Animal entry.
     * http://localhost:8080/animals/new
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public Object addAnimal(Animal animal){
        service.addAnimal(animal);
        return "redirect:/animals/all";
    }

    /**
     * Show the update form.
     *
     * @param animalId
     * @param model
     * @return the update form view.
     */
    @GetMapping("/update/{animalId}")
    public String showUpdatedForm(@PathVariable int animalId, Model model){
        model.addAttribute("animal", service.getAnimalById(animalId));
        model.addAttribute("title", "Update Animal");
        return "animal-update";
    }
    /**
     * Update an existing Animals object.
     * http://localhost:8080/animals/update/2
     *
     * @param animalId the unique Animal Id.
     * @param animal the new update details.
     * @return the updated Animal object.
     */
    @PostMapping("/update/{animalId}")
    public Object updateAnimal(@PathVariable int animalId, Animal animal) {
        service.updateAnimal(animalId, animal);
        return "redirect:/animals/" + animalId;
    }

    /**
     * Delete a Animal object.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @GetMapping("/delete/{animalId}")
    public Object deleteAnimalId(@PathVariable int animalId){
        service.deleteAnimalById(animalId);
        return "redirect:/animals/all";
    }
}
