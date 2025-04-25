package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.MessageRepository;

import com.example.entity.Message;

@Service
public class MessageService {
    MessageRepository messageRepository;
    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // Creates a new message
    public Message createNewMessage(Message m) {
        return messageRepository.save(m);
    }

    // Gets all messages from the database
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    
    // Gets a message based on the primary key
    public Message getMessageWithId(int id) {
        Optional<Message> om = messageRepository.findById(id);
        return om.orElse(null);
    }

    // Deletes a message based on the primary key
    public Integer deleteMessageWithId(int id) {
        // If the message id exists, delete it and return 1
        if (messageRepository.existsById(id)) {
            messageRepository.deleteById(id);
            return 1;
        }
        // If the message id does not exist, return null
        return null;
    }
    // Updates a message based on the primary key
    public Integer updateMessageWithId(String mt, int id) {
        Optional<Message> om = messageRepository.findById(id);
        // If the messaage is found, return update the text and return 1
        if(om.isPresent()) {
            Message message = om.get();
            message.setMessageText(mt);
            messageRepository.save(message);
            return 1;
        }
        // If the message is not found, do nothing and return null
        return null;
    }
    // Gets all messages posted by a user with accountid = id
    public List<Message> getMessagesFromAccount(int id) {
        return messageRepository.findByPostedBy(id);
    }
}
