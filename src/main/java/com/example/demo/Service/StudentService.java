package com.example.demo.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Model.Dto.StudentDto;
import com.example.demo.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * demoCache
 *
 * @author duongnch
 * @created_at 25/05/2020 - 11:44 AM
 * @created_by duongnch
 * @since 25/05/2020
 */
@Service
public class StudentService {

    ModelMapper mapper = new ModelMapper();
    Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    StudentRepository studentRepository;

    @Cacheable(value = "students")
    public Page<Student> getListStudent(Pageable pageable) {
        Page<Student> students = studentRepository.findAll(pageable);
        return students;
    }

    public Student createStudent(StudentDto studentDto) {
        return studentRepository.save(mapper.map(studentDto, Student.class));
    }


    @Cacheable(value = "student", key = "#studentid")
    public Student getStudent(int studentid) {
        return studentRepository.findById(studentid).get();
    }

    @Cacheable(value = "studentName", key = "{#pageable,#studentName}")
//    @CachePut(value = "studentName", key = "#studentName")
    public Page<Student> listStudentName(String studentName,Pageable pageable) {
        return studentRepository.findAllByName(studentName, pageable);
    }

    public Student updateStudent(StudentDto studentDto) {
        return studentRepository.save(mapper.map(studentDto, Student.class));
    }
}
