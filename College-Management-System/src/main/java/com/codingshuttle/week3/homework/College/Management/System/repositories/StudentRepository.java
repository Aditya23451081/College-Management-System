package com.codingshuttle.week3.homework.College.Management.System.repositories;

import com.codingshuttle.week3.homework.College.Management.System.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
