package com.codingshuttle.week3.homework.College.Management.System.controllers;

import com.codingshuttle.week3.homework.College.Management.System.entities.SubjectEntity;
import com.codingshuttle.week3.homework.College.Management.System.services.SubjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

  @GetMapping("/{subjectId}")
  public SubjectEntity getSubjectDetails(@PathVariable Long subjectId){
        return subjectService.getSubjectDetails(subjectId);
  }

  @PostMapping
   public SubjectEntity createNewSubject(@RequestBody SubjectEntity subjectEntity){
        return subjectService.createNewSubject(subjectEntity);
  }

  @PutMapping(path = "/{subjectId}/Teaches/{studentId}")
  public SubjectEntity assignStudentToSubject(@PathVariable Long subjectId,
                                              @PathVariable Long studentId){
        return subjectService.assignStudentToSubject(subjectId,studentId);
  }
}
