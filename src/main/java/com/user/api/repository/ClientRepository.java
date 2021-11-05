/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.api.repository;

import com.user.api.model.Client;
import com.user.api.repository.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
  
    @Autowired
    private ClientCrudRepository clientCrudRespository;
    
    public List<Client> getAll() {
        return (List<Client>)clientCrudRespository.findAll(); 
    }
    
    public Optional<Client> getClient(int id){
        return clientCrudRespository.findById(id);
    }
    
    public Client save(Client client){
        return clientCrudRespository.save(client);
    }
    
    public void delete(Client client){
        clientCrudRespository.delete(client);
    }
}
