package com.example.demo.Repository;

import com.example.demo.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * demoCache
 *
 * @author duongnch
 * @created_at 25/05/2020 - 11:44 AM
 * @created_by duongnch
 * @since 25/05/2020
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Page<Student> findAllByName(String name, Pageable pageable);
    Page<Student> findAll(Pageable page);
}
