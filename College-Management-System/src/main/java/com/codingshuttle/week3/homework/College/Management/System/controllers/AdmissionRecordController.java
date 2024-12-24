package com.codingshuttle.week3.homework.College.Management.System.controllers;


import com.codingshuttle.week3.homework.College.Management.System.entities.AdmissionRecordEntity;
import com.codingshuttle.week3.homework.College.Management.System.services.AdmissionRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Admission")
public class AdmissionRecordController {
  private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @GetMapping("/{admissionId}")
    public AdmissionRecordEntity getAdmissionRecords(@PathVariable Long admissionId){
        return admissionRecordService.getAdmissionRecords(admissionId);
    }

    @PostMapping
    public AdmissionRecordEntity createNewAdmission(@RequestBody AdmissionRecordEntity admissionRecordEntity){
        return  admissionRecordService.createNewAdmission(admissionRecordEntity);
    }
}
