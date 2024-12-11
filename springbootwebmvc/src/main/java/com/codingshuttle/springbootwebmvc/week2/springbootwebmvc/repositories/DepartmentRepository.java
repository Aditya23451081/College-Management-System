package com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.repositories;

import com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long>{


}
