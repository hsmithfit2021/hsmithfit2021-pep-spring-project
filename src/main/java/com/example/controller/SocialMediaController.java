package com.example.controller;

import com.example.entity.Account;
import com.example.entity.Message;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@Controller
public class SocialMediaController {
    @PostMapping("register")
    public @ResponseBody Account register(@RequestBody Account a) {
        return null;
    }

    @PostMapping("login")
    public @ResponseBody Account login(@RequestBody Account a) {
        return null;
    }
    @PostMapping("messages")
    public @ResponseBody Message createNewMessage(@RequestBody Message m) {
        return null;
    }
    @GetMapping("messages")
    public @ResponseBody List<Message> getAllMessages() {
        return null;
    }
    @GetMapping("messages/{messageId}")
    public @ResponseBody Message getOneMessageGivenMessageId(@PathVariable int messageId) {
        return null;
    }
    @DeleteMapping("messages/{messageId}")
    public @ResponseBody Integer deleteMessageGivenMessageId(@PathVariable int messageId) {
        return null;
    }
    @PatchMapping("messages/{messageId}")
    public @ResponseBody Integer updateMessageGivenMessageId(@PathVariable int messageId, @RequestBody String mt) {
        return null;
    }
    @GetMapping("accounts/{accountId}/messages")
    public @ResponseBody Message getAllMessagesGivenAccountId(@PathVariable int accountId) {
        return null;
    }
}
