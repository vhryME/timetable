package com.epolsoft.repo;

import com.epolsoft.domain.Message;
import com.epolsoft.out.MessagePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MessageAdapter implements MessagePort {

    private final MessageRepo repo;
    private final MessageMapper mapper;

    @Override
    public Message getMessage(Long id) throws Exception {
        Optional<MessageJpa> message = Optional.of(repo.getOne(id));

        return mapper.messageJpaToMessage(
                message.orElseThrow(
                        () -> new Exception(String.format("Message with id = {%s} is not found", id))));
    }

    @Override
    public Message getMessageByContent(String content) throws Exception {
        Optional<MessageJpa> message = repo.findOne(MessageSpecifications.findByContent(content));

        return mapper.messageJpaToMessage(
                message.orElseThrow(
                        () -> new Exception(String.format("Message with content = {%s} is not found", content))));
    }

}
