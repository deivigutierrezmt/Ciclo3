/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.api.controller;

import com.user.api.model.Doctor;
import com.user.api.service.DoctorService;
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
@RequestMapping("/api/Doctor")
@CrossOrigin( origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT ,RequestMethod.DELETE})
public class DoctorController {
    @Autowired
    private DoctorService  doctorservice;
    
    @GetMapping("/all")
    public List<Doctor> listDoctor(){
        return doctorservice.getAll();
    } 
    
    @GetMapping("/{id}")
    public Optional<Doctor> consultaDoctor(@PathVariable("id")int id){
        return doctorservice.getDoctor(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        return doctorservice.doctorSave(doctor);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor updateDoctor(@RequestBody Doctor doctor){
        return doctorservice.doctorUpdate(doctor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteDoctor(@PathVariable("id")int id){
        return doctorservice.doctorDelete(id);
    } 
}
