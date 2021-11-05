/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.api.repository;

import com.user.api.model.Specialty;
import com.user.api.repository.crud.SpecialtyCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SpecialtyRepository {
    
    @Autowired
    private SpecialtyCrudRepository specialtyCrudRespository;
    
    public List<Specialty> getAll() {
        return (List<Specialty>)specialtyCrudRespository.findAll(); 
    }
    
    public Optional<Specialty> getSpecialty(int id){
        return specialtyCrudRespository.findById(id);
    }
    
    public Specialty save(Specialty specialty){
        return specialtyCrudRespository.save(specialty);
    }
    
    public void delete(Specialty specialty){
        specialtyCrudRespository.delete(specialty);
    }
    
}
