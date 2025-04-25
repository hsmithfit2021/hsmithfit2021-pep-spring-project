package com.example.controller;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.entity.MessageText;
import com.example.service.MessageService;
import com.example.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {
    MessageService messageService;
    AccountService accountService;
    
    @Autowired
    public SocialMediaController(MessageService messageService, AccountService accountService) {
        this.messageService = messageService;
        this.accountService = accountService;
    }

    // Register a new account at POST: /register
    @PostMapping("register")
    public ResponseEntity register(@RequestBody Account a) {
        // Checks for an invalid usedname length
        if(a.getUsername().length() < 4) {
            return ResponseEntity.status(400).body("");
        }
        Account registered = accountService.register(a);
        // Checks if the account username already exists
        if(registered == null) {
            return ResponseEntity.status(409).body("");
        }
        // Successful Registration
        return ResponseEntity.status(200).body(registered);
    }

    // Login to an account at POST: /login
    @PostMapping("login")
    public ResponseEntity login(@RequestBody Account a) {
        Account loginAccount = accountService.login(a);
        // Checks if the username exists, and if the password matches
        if(loginAccount == null) {
            return ResponseEntity.status(401).body("");
        }
        // Successful Login
        return ResponseEntity.status(200).body(loginAccount);
    }

    // Create a new message at POST: /messages
    @PostMapping("messages")
    public ResponseEntity createNewMessage(@RequestBody Message m) {
        // Checks for valid message length, and that the account the message is posted from exists
        if(m.getMessageText().length() < 1 || m.getMessageText().length() > 255 || !accountService.exists(m.getPostedBy())) {
            return ResponseEntity.status(400).body("");
        }
        // Successful Post
        return ResponseEntity.status(200).body(messageService.createNewMessage(m));
    }

    // Gets all messages at GET: /messages
    @GetMapping("messages")
    public ResponseEntity getAllMessages() {
        return ResponseEntity.status(200).body(messageService.getAllMessages());
    }

    // Gets a message with a matching {messageId} at GET: messages/{messageId}
    @GetMapping("messages/{messageId}")
    public ResponseEntity getOneMessageGivenMessageId(@PathVariable int messageId) {
        return ResponseEntity.status(200).body(messageService.getMessageWithId(messageId));
    }

    // Deletes a message with a matching {messageId} at DELETE: messages/{messageId}
    @DeleteMapping("messages/{messageId}")
    public ResponseEntity deleteMessageGivenMessageId(@PathVariable int messageId) {
        return ResponseEntity.status(200).body(messageService.deleteMessageWithId(messageId));
    }
    // Updates a message with a matching {messageId} at PATCH: messages/{messageId}
    @PatchMapping("messages/{messageId}")
    public ResponseEntity updateMessageGivenMessageId(@PathVariable int messageId, @RequestBody MessageText mt) {
        // Checks for invalid message length
        if(mt.getMessageText().length() < 1 || mt.getMessageText().length() > 255) {
            return ResponseEntity.status(400).body("");
        }
        Integer i = messageService.updateMessageWithId(mt.getMessageText(), messageId);
        // Checks if the original message didn't exist
        if(i == null) {
            return ResponseEntity.status(400).body("");
        }
        // Successful Update
        return ResponseEntity.status(200).body(i);
    }
    // Gets messages posted by an account with a matching {accountId} at GET: /accounts/{accountId}/messages
    @GetMapping("accounts/{accountId}/messages")
    public ResponseEntity getAllMessagesGivenAccountId(@PathVariable int accountId) {
        return ResponseEntity.status(200).body(messageService.getMessagesFromAccount(accountId));
    }
}
