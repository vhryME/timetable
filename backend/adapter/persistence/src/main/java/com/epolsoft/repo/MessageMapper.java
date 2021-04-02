package com.epolsoft.repo;

import com.epolsoft.domain.Message;
import com.epolsoft.repo.MessageJpa;

public interface MessageMapper {
    Message messageJpaToMessage(MessageJpa messageJpa);
    MessageJpa messageToMessageJpa(Message message);
}
