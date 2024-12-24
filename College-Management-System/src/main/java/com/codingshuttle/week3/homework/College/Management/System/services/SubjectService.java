package com.codingshuttle.week3.homework.College.Management.System.services;

import com.codingshuttle.week3.homework.College.Management.System.entities.StudentEntity;
import com.codingshuttle.week3.homework.College.Management.System.entities.SubjectEntity;
import com.codingshuttle.week3.homework.College.Management.System.repositories.StudentRepository;
import com.codingshuttle.week3.homework.College.Management.System.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    public SubjectService(SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public SubjectEntity getSubjectDetails(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }

    public SubjectEntity createNewSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    public SubjectEntity assignStudentToSubject(Long subjectId, Long studentId) {
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        return subjectEntity.flatMap(subject->
                studentEntity.map(student -> {
                    student.getSubjects().add(subject);
                    studentRepository.save(student);
                    subject.getStudents().add(student);
                    return subjectRepository.save(subject);
                })).orElse(null);

    }
}
