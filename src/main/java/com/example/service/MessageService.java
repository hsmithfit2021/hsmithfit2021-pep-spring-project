package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.repository.MessageRepository;

import com.example.entity.Message;

public class MessageService {
    MessageRepository messageRepository;
    @Autowired
    public MessageService(MessageRepository mr) {
        this.messageRepository = mr;
    }

    public Message createNewMessage(Message m) {
        return messageRepository.save(m);
    }
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    public Message getMessageWithId(int id) {
        return messageRepository.getById(id);
    }
    public Integer deleteMessageWithId(int id) {
        if (messageRepository.existsById(id)) {
            messageRepository.deleteById(id);
            return 1;
        }
        return null;
    }
    public Integer updateMessageWithId(String mt, int id) {
        if (messageRepository.existsById(id)) {
            Message m = messageRepository.getById(id);
            m.setMessageText(mt);
            messageRepository.save(m);
            return 1;
        }
        return null;
    }
    public List<Message> getMessagesFromAccount(int id) {
        return messageRepository.findByPostedBy(id);
    }
}
