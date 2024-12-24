package com.codingshuttle.week3.homework.College.Management.System.repositories;

import com.codingshuttle.week3.homework.College.Management.System.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity,Long> {
}
