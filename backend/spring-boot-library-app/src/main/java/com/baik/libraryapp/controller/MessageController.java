package com.baik.libraryapp.controller;

import com.baik.libraryapp.entity.Message;
import com.baik.libraryapp.requestmodels.AdminQuestionRequest;
import com.baik.libraryapp.service.MessagesService;
import com.baik.libraryapp.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private MessagesService messagesService;

    @Autowired
    public MessageController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }


    @PostMapping("/secure/add/message")
    public void postMessage(@RequestHeader(value = "Authorization") String token,
                            @RequestBody Message messageRequest) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        messagesService.postMessage(messageRequest, userEmail);
    }


    @PutMapping("/secure/admin/message")
    public void putMessage(@RequestHeader(value = "Authorization") String token,
                           @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
//        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
//
//        if(admin == null || !admin.equals("admin")) {
//            throw new Exception("Administrator only");
//        }

        messagesService.putMessage(adminQuestionRequest, userEmail);
    }


    @GetMapping("/secure/admin/findMessagessByClosed")
    public int findMessagessByClosed(@RequestHeader(value = "Authorization") String token,
                                               @RequestParam(value = "closed") boolean closed) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        return messagesService.findMessagessByClosed(closed, userEmail);
    }


}
