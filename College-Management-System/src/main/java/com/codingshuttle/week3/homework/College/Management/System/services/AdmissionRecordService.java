package com.codingshuttle.week3.homework.College.Management.System.services;

import com.codingshuttle.week3.homework.College.Management.System.entities.AdmissionRecordEntity;
import com.codingshuttle.week3.homework.College.Management.System.repositories.AdmissionRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class AdmissionRecordService {
private final AdmissionRecordRepository admissionRecordRepository;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
    }

    public AdmissionRecordEntity getAdmissionRecords(Long admissionId) {
        return admissionRecordRepository.findById(admissionId).orElse(null);
    }

    public AdmissionRecordEntity createNewAdmission(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepository.save(admissionRecordEntity);
    }

}
