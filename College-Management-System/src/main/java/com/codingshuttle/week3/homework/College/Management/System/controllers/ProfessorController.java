package com.codingshuttle.week3.homework.College.Management.System.controllers;

import com.codingshuttle.week3.homework.College.Management.System.entities.ProfessorEntity;
import com.codingshuttle.week3.homework.College.Management.System.entities.StudentEntity;
import com.codingshuttle.week3.homework.College.Management.System.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/professors")
public class ProfessorController {

private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

  @GetMapping("/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable Long professorId){
     return professorService.getProfessorById(professorId);
   }

   @PostMapping
   public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professorEntity){
        return professorService.createNewProfessor(professorEntity);
    }

    @PutMapping(path = "/{professorId}/teaches/{subjectId}")
    public ProfessorEntity assignSubjectToProfessor(@PathVariable Long professorId,
                                                    @PathVariable Long subjectId){

        return professorService.assignSubjectToProfessor(professorId,subjectId);
    }

   }
