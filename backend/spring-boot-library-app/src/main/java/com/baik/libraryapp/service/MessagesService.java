package com.baik.libraryapp.service;

import com.baik.libraryapp.dao.MessageRepository;
import com.baik.libraryapp.entity.Message;
import com.baik.libraryapp.requestmodels.AdminQuestionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MessagesService {

    private MessageRepository messageRepository;


    @Autowired
    public MessagesService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void postMessage(Message messageRequest, String userEmail) {
        Long mid = messageRepository.findMid();

        Message message = new Message(messageRequest.getTitle(), messageRequest.getQuestion());
        message.setUserEmail(userEmail);
        message.setMid(++mid);

        messageRepository.save(message);
    }


    public void putMessage(AdminQuestionRequest adminQuestionRequest, String userEmail) throws Exception {
        Optional<Message> message = messageRepository.findByMId(adminQuestionRequest.getMid());

        if(!message.isPresent()) {
            throw new Exception("Message not found");
        }

        message.get().setAdminEmail(userEmail);
        message.get().setResponse(adminQuestionRequest.getResponse());
        message.get().setMid(adminQuestionRequest.getMid());
        message.get().setClosed(true);
        messageRepository.save(message.get());
    }


    public int findMessagessByClosed(boolean closed, String userEmail) {
        return messageRepository.findMessagessByClosed(closed, userEmail);
    }


}
