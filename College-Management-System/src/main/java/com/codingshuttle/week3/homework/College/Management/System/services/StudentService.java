package com.codingshuttle.week3.homework.College.Management.System.services;

import com.codingshuttle.week3.homework.College.Management.System.entities.AdmissionRecordEntity;
import com.codingshuttle.week3.homework.College.Management.System.entities.ProfessorEntity;
import com.codingshuttle.week3.homework.College.Management.System.entities.StudentEntity;
import com.codingshuttle.week3.homework.College.Management.System.repositories.AdmissionRecordRepository;
import com.codingshuttle.week3.homework.College.Management.System.repositories.ProfessorRespository;
import com.codingshuttle.week3.homework.College.Management.System.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ProfessorRespository professorRespository;
    private final AdmissionRecordRepository admissionRecordRepository;

    public StudentService(StudentRepository studentRepository, ProfessorRespository professorRespository, AdmissionRecordRepository admissionRecordRepository) {
        this.studentRepository = studentRepository;
        this.professorRespository = professorRespository;
        this.admissionRecordRepository = admissionRecordRepository;
    }

    public StudentEntity createNewStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public StudentEntity assignProfessorToStudent(Long studentId, Long professorId) {
         Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
         Optional<ProfessorEntity> professorEntity = professorRespository.findById(professorId);
      return studentEntity.flatMap(student->
              professorEntity.map(professor -> {
                professor.getStudents().add(student);
                professorRespository.save(professor);
                student.getProfessors().add(professor);
                return student;
                      })).orElse(null);

    }

    public StudentEntity assignAdmissionRecordToStudent(Long studentId, Long admissionId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepository.findById(admissionId);
        return studentEntity.flatMap(student ->
                admissionRecordEntity.map(admission -> {
                    student.setAdmissionRecord(admission);
                    admission.setStudent(student);
                    admissionRecordRepository.save(admission);
                    return studentRepository.save(student);
                })).orElse(null);

    }
}
