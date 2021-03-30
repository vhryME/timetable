package com.epolsoft.service;

import com.epolsoft.domain.Message;
import com.epolsoft.repo.MessageJpa;
import com.epolsoft.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepo repo;

    public Message getMessage(Long id) {
        if (repo != null) {
            MessageJpa messageJpa = repo.getOne(id);
            return new Message()
                    .setId(messageJpa.getId())
                    .setContent(messageJpa.getContent()); //todo refactor with mapstruct
        }

        return null;
    }

    public Message getMessageByContent(String content) {
        if (repo != null) {

            MessageJpa messageJpa = repo.findByContent(content);
            return new Message()
                    .setId(messageJpa.getId())
                    .setContent(messageJpa.getContent()); //todo refactor with mapstruct
        }

        return null;
    }
}
