package com.epolsoft.out;

import com.epolsoft.domain.Message;

public interface MessagePort {

    Message getMessage(Long id) throws Exception;

    Message getMessageByContent(String content) throws Exception;

}
