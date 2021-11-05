/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.api.controller;

import com.user.api.model.Specialty;
import com.user.api.service.SpecialtyService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SpecialtyController {
    
    @Autowired
    private SpecialtyService  specialtyService;
    
    @GetMapping("/all")
    public List<Specialty> listSpecialty (){
        return specialtyService.getAll();
    } 
    
    @GetMapping("/{id}")
    public Optional<Specialty> consultaSpecialty(@PathVariable("id")int id){
        return specialtyService.getSpecialty(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty saveSpecialty(@RequestBody Specialty specialty){
        return specialtyService.specialtySave(specialty);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty updateSpecialty(@RequestBody Specialty specialty){
        return specialtyService.specialtyUpdate(specialty);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteSpecialty(@PathVariable("id")int id){
        return specialtyService.specialtyDelete(id);
    }
    
    
}
