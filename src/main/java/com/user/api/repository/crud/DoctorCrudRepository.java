/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.api.repository.crud;

import com.user.api.model.Doctor;
import org.springframework.data.repository.CrudRepository;


public interface DoctorCrudRepository extends CrudRepository<Doctor, Integer>{
    
}
