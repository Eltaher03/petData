package com.abdelrahman.assignment2.petDataAssignment.controller;

import com.abdelrahman.assignment2.petDataAssignment.model.Pet;
import com.abdelrahman.assignment2.petDataAssignment.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/pets")
public class PetController {
    private final PetRepository petRepository;

    @Autowired
    public PetController(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    @GetMapping("list")
    public String listAllPets(Model model){
        Pet pet1 =new Pet(1,"pet1","dog","male","not vaccinated");
        Pet pet2 =new Pet(2,"pet2","cat","female","vaccinated");
        Pet pet3 =new Pet(3,"pet3","cat","male","vaccinated");
        Pet pet4 =new Pet(4,"pet4","dog","female","vaccinated");

        petRepository.save(pet1);
        petRepository.save(pet2);
        petRepository.save(pet3);
        petRepository.save(pet4);
        model.addAttribute("pets",petRepository.findAll());

        return "index";
    }


    @GetMapping("show")
    public String showAddPetForm(Pet pet){
        return "add-pet";
    }


    @PostMapping("add")
    public String addPet(@Valid Pet pet, BindingResult result,
                         Model model){
        if(result.hasErrors()){
            return "add-pet";
        }
        petRepository.save(pet);
        return "redirect:list";

    }
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("pet", pet);
        return "update-pet";
    }

    @PostMapping("update/{id}")
    public String updatePet(@PathVariable("id") long id, @Valid Pet pet, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            pet.setId(id);
            return "update-pet";
        }

        petRepository.save(pet);
        model.addAttribute("pets", petRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deletePet(@PathVariable("id") long id, Model model) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid student Id:" + id));
        petRepository.delete(pet);
        model.addAttribute("pets", petRepository.findAll());
        return "index";
    }
}