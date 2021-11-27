package com.vhry.file.repo;


import com.vhry.file.domain.FileJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface FileRepository extends JpaRepository<FileJpa, UUID> {
    FileJpa findByUuid(UUID uuid);
}