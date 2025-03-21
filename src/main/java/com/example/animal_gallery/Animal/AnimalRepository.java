package com.example.animal_gallery.Animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> getAnimalBySpecies(String species);

    @Query(value = "SELECT * from animals a WHERE a.name LIKE %?1%", nativeQuery = true)
    List<Animal> getAnimalByName(String name);

    @Query(value = "SELECT * FROM animals a WHERE a.age >= ?1", nativeQuery = true)
    List<Animal> getOlderAnimals(double age);
}
