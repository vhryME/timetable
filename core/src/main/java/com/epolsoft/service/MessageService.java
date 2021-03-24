package com.epolsoft.service;

import com.epolsoft.domain.Message;
import com.epolsoft.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepo repo;

    public Message getMessage(Long id) {
        if(repo != null) {
            return repo.getOne(id);
        }

        return null;
    }

    public Message getMessageByContent(String content) {
        if(repo != null) {
            return repo.findByContent(content);
        }

        return null;
    }
}
