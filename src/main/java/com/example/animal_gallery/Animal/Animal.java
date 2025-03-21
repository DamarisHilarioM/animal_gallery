package com.example.animal_gallery.Animal;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private String species;

    @Column(nullable = false)
    private double age;

    @Temporal(TemporalType.DATE)
    private Date activeDate;


    // Constructors
    public Animal(int animalId, String name, String description, String breed, double age, Date activeDate){
        this.animalId = animalId;
        this.name = name;
        this.description = description;
        this.species = species;
        this.age = age;
        this.activeDate = activeDate;
    }

    public Animal(String name, String description, String breed, double age, Date activeDate){
        this.name = name;
        this.description = description;
        this.species = species;
        this.age = age;
        this.activeDate = activeDate;
    }

    public Animal(){
    }

    //Getters and Setters
    public int getAnimalId(){
        return animalId;
    }

    public void setAnimalId(int animalId){
        this.animalId = animalId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getSpecies(){
        return species;
    }

    public void setSpecies(String breed){
        this.species = species;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }
}
