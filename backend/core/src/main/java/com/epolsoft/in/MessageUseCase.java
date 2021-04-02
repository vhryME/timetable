package com.epolsoft.in;

import com.epolsoft.domain.Message;

public interface MessageUseCase {

    Message getMessage(Long id) throws Exception;

    Message getMessageByContent(String content) throws Exception;

}
