package com.epolsoft.repo;

import com.epolsoft.domain.Message;
import org.springframework.stereotype.Component;

//todo replace with mapstruct
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public Message messageJpaToMessage(MessageJpa messageJpa) {
        if(messageJpa != null) {
            Message message = new Message();

            message.setContent(messageJpa.getContent());

            return message;
        }

        return null;
    }

    @Override
    public MessageJpa messageToMessageJpa(Message message) {
        if(message != null) {
            MessageJpa messageJpa = new MessageJpa();

            messageJpa.setContent(message.getContent());

            return messageJpa;
        }

        return null;
    }
}
