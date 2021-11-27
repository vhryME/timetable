package com.vhry.dictionary.universityRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityJpaDictionaryRepository extends JpaRepository<UniversityRoleJpa, Long> {

}
