/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.api.service;

import com.user.api.model.Message;
import com.user.api.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRespository;

    public List<Message> getAll() {
        return messageRespository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRespository.getMessage(id);
    }

    public Message messageSave(Message message) {
        if (message.getIdMessage() == null) {
            return messageRespository.save(message);
        } else {
            Optional<Message> messageAux = messageRespository.getMessage(message.getIdMessage());
            if (messageAux.isEmpty()) {
                return messageRespository.save(message);
            } else {
                return message;
            }
        }
    }

    public Message messageUpdate(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> messageAux = messageRespository.getMessage(message.getIdMessage());
            if (!messageAux.isEmpty()) {
                if (message.getMessageText() != null) {
                    messageAux.get().setMessageText(message.getMessageText());
                }
                return messageRespository.save(message);
            }//fin del messagee aux
        }
        return message;
    }

    public boolean messageDelete(int id) {
        Optional<Message> messageAux = messageRespository.getMessage(id);
        if (!messageAux.isEmpty()) {
            messageRespository.delete(messageAux.get());
            return true;
        }
        return false;
    }

}
