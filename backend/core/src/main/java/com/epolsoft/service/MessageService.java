package com.epolsoft.service;

import com.epolsoft.domain.Message;
import com.epolsoft.in.MessageUseCase;
import com.epolsoft.out.MessagePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService implements MessageUseCase {

    private final MessagePort port;

    @Override
    public Message getMessage(Long id) throws Exception {
        try {
            return port.getMessage(id);
        } catch (Exception exception) {
            throw new Exception("Get data exception", exception);
        }
    }

    @Override
    public Message getMessageByContent(String content) throws Exception {
        try {
            return port.getMessageByContent(content);
        } catch (Exception exception) {
            throw new Exception("Get data exception", exception);
        }
    }

}
