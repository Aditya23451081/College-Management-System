package com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Department")
public class DepartmentEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;

    private String departmentTitle;

    @JsonProperty
    private Boolean isActive;

    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdAt;

    private Integer number;

}
