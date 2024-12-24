package com.codingshuttle.week3.homework.College.Management.System.repositories;

import com.codingshuttle.week3.homework.College.Management.System.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRespository extends JpaRepository<ProfessorEntity,Long> {

}
