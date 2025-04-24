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
        return null;
    }
    public List<Message> getAllMessages() {
        return null;
    }
    public Message getMessageWithId(int id) {
        return null;
    }
    public Message deleteMessageWithId(int id) {
        return null;
    }
    public Message updateMessageWithId(Message m, int id) {
        return null;
    }
    public List<Message> getMessagesFromAccount(int id) {
        return null;
    }
}
