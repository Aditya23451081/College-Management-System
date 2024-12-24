package com.codingshuttle.week3.homework.College.Management.System.controllers;

import com.codingshuttle.week3.homework.College.Management.System.entities.StudentEntity;
import com.codingshuttle.week3.homework.College.Management.System.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public StudentEntity getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity){
        return studentService.createNewStudent(studentEntity);
     }

    @PutMapping(path = "/{studentId}/Student/{professorId}")
    public StudentEntity assignProfessorToStudent(@PathVariable Long studentId,
                                            @PathVariable Long professorId){
        return studentService.assignProfessorToStudent(studentId,professorId);
    }

    @PutMapping(path = "/{studentId}/Admitted/{admissionId}")
    public StudentEntity assignAdmissionRecordToStudent(@PathVariable Long studentId,
                                                        @PathVariable Long admissionId){

        return studentService.assignAdmissionRecordToStudent(studentId,admissionId);
    }
}
