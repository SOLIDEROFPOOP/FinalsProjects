package com.muratkapparov.springbootlibrary.controller;

import com.muratkapparov.springbootlibrary.RequestModels.AdminQuestionRequest;
import com.muratkapparov.springbootlibrary.entity.Message;
import com.muratkapparov.springbootlibrary.service.MessageService;
import com.muratkapparov.springbootlibrary.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/messages")
public class MessageController {
    private MessageService messageService;
    @Autowired
    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }
    @PostMapping("/secure/add/message")
    public void postMessage(@RequestHeader(value = "Authorization") String token, @RequestBody Message messageRequest){
        String email = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        messageService.postMessage(messageRequest, email);
    }
    @PutMapping("/secure/admin/message")
    public void putMessage(@RequestHeader(value = "Authorization") String token , @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception{
        String email = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")){
            throw new Exception("ADMIN ONLY!!");
        }
        messageService.putMessage(adminQuestionRequest, email);
    }
}
