package com.punsaeng.pag.repository;

import com.punsaeng.pag.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    Optional<Classroom> findByNameAndGrade(String name, int grade);
}