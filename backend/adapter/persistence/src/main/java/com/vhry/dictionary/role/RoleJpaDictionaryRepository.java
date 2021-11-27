package com.vhry.dictionary.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleJpaDictionaryRepository extends JpaRepository<RoleJpa, Long> {

}
