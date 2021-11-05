/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.user.api.repository.crud;


import com.user.api.model.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Orthex
 */
public interface ClientCrudRepository extends CrudRepository<Client, Integer>{
    
    
}
