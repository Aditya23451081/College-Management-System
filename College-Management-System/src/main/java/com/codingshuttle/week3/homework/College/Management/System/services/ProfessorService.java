package com.codingshuttle.week3.homework.College.Management.System.services;

import com.codingshuttle.week3.homework.College.Management.System.entities.ProfessorEntity;
import com.codingshuttle.week3.homework.College.Management.System.entities.SubjectEntity;
import com.codingshuttle.week3.homework.College.Management.System.repositories.ProfessorRespository;
import com.codingshuttle.week3.homework.College.Management.System.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {
    private final ProfessorRespository professorRespository;
    private final SubjectRepository subjectRepository;

    public ProfessorService(ProfessorRespository professorRespository, SubjectRepository subjectRepository) {
        this.professorRespository = professorRespository;
        this.subjectRepository = subjectRepository;
    }

    public ProfessorEntity getProfessorById(Long professorId) {
       return professorRespository.findById(professorId).orElse(null);
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professorEntity) {
        return professorRespository.save(professorEntity);
    }

    public ProfessorEntity assignSubjectToProfessor(Long professorId, Long subjectId) {
        Optional<ProfessorEntity> professorEntity = professorRespository.findById(professorId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);

        return professorEntity.flatMap(professor ->
                subjectEntity.map(subject ->
                {
                    subject.setTaughtByProfessor(professor);
                      subjectRepository.save(subject);
                      professor.getSubjects().add(subject);
                    return professor;
                })).orElse(null);

    }
}
