package com.epolsoft.repo;

import com.epolsoft.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long>{
    Message findByContent(String content);
}
