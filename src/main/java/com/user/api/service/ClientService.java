/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.api.service;

import com.user.api.model.Client;
import com.user.api.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRespository;

    public List<Client> getAll() {
        return clientRespository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRespository.getClient(id);
    }

    public Client clientSave(Client client) {
        if (client.getIdClient() == null) {
            return clientRespository.save(client);
        } else {
            Optional<Client> clientAux = clientRespository.getClient(client.getIdClient());
            if (clientAux.isEmpty()) {
                return clientRespository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client clientUpdate(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> clientAux = clientRespository.getClient(client.getIdClient());
            if (!clientAux.isEmpty()) {
                if (client.getName() != null) {
                    clientAux.get().setName(client.getName());
                }
                if (client.getEmail()!= null) {
                    clientAux.get().setEmail(client.getEmail());
                }
                if (client.getPassword()!= null) {
                    clientAux.get().setPassword(client.getPassword());   
                }
                if (client.getAge()!= null) {
                    clientAux.get().setAge(client.getAge());   
                }
                return clientRespository.save(client);
            }//fin del cliente aux
        }
        return client;
    }
    
    public boolean clientDelete(int id){
        Optional<Client> clientAux = clientRespository.getClient(id);
        if (!clientAux.isEmpty()) {
            clientRespository.delete(clientAux.get());
            return true;
        }
        return false;
    }
}
