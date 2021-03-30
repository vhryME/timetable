package com.epolsoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<MessageJpa, Long> {
    MessageJpa findByContent(String content);
}
