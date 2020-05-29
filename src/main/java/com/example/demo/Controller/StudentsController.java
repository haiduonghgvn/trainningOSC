package com.example.demo.Controller;

import com.example.demo.Config.Translator;
import com.example.demo.Entity.Student;
import com.example.demo.Model.APIResponse.APIResponse;
import com.example.demo.Model.Dto.StudentDto;
import com.example.demo.Model.Mapper.APIResponseMapper;
import com.example.demo.Service.StudentService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

 import javax.validation.Valid;

 /**
 * demoCache
 *
 * @author duongnch
 * @created_at 25/05/2020 - 11:43 AM
 * @created_by duongnch
 * @since 25/05/2020
 */

@RestController
@Log4j
@RequestMapping("/private/v1/students")
public class StudentsController {

    @Autowired
    StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getByID")
    public ResponseEntity<Object> getAuthor(@RequestParam int studentID ) {
        long startTime = System.currentTimeMillis();
        Student student = studentService.getStudent(studentID);
        APIResponseMapper apiResponse = new APIResponseMapper();
        APIResponse<Student> listStudent = apiResponse.mapperAPIResponse(HttpStatus.OK.value(), Translator.toLocale("SUCCESS_MESSAGE"), Translator.toLocale("SUCCESS_DESCRIPTIONS"), student);

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("---------> Get Student by id = " + studentID + ",-> Time Elapsed: " + duration + " ms");
        return ResponseEntity.ok(listStudent);
    }

    @GetMapping("/getByName")
    public ResponseEntity<Object> getStudentName(@RequestParam String studentName,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "2") int size) {

        long startTime = System.currentTimeMillis();
        long duration = System.currentTimeMillis() - startTime;
        Page<Student> student = studentService.listStudentName(studentName, PageRequest.of(page, size));
        APIResponseMapper apiResponse = new APIResponseMapper();
        APIResponse<Page<Student>> listStudent = apiResponse.mapperAPIResponse(HttpStatus.OK.value(), Translator.toLocale("SUCCESS_MESSAGE"), Translator.toLocale("SUCCESS_DESCRIPTIONS"), student);
        System.out.println("---------> Get Student by id = " + studentName + ",-> Time Elapsed: " + duration + " ms");
        return new ResponseEntity<>(listStudent, HttpStatus.OK);

    }

    @GetMapping("")
    public ResponseEntity<Object> getListStudents(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "5") int size) {

        long startTime = System.currentTimeMillis();
        Page<Student> student = studentService.getListStudent(PageRequest.of(page, size));
        APIResponseMapper apiResponse = new APIResponseMapper();
        APIResponse<Page<Student>> listStudent = apiResponse.mapperAPIResponse(HttpStatus.OK.value(), Translator.toLocale("SUCCESS_MESSAGE"), Translator.toLocale("SUCCESS_DESCRIPTIONS"), student);
        long duration = System.currentTimeMillis() - startTime;


        System.out.println("---------> Get all Student,-> Time Elapsed: " + duration + " ms");
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Student> updateStudent(@RequestBody StudentDto s) {
        return ResponseEntity.ok(studentService.updateStudent(s));
    }

    @PostMapping("")
    public ResponseEntity<Object> createStudent(@Valid @RequestBody StudentDto studentDto) {
        APIResponseMapper apiResponseMapper = new APIResponseMapper();
        APIResponse apiResponse = apiResponseMapper.mapperAPIResponse(HttpStatus.OK.value(),Translator.toLocale("SUCCESS_MESSAGE"), Translator.toLocale("SUCCESS_DESCRIPTIONS"),studentService.createStudent(studentDto));
        return ResponseEntity.ok(apiResponse);
    }
}
