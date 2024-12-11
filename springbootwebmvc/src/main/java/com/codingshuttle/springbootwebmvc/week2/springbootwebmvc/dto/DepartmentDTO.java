package com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {


    private Long Id;

    @Pattern(regexp = "^SALES|IT|HR|ACCOUNTS$",message = "The department can be SALES,IT,HR or ACCOUNTS")
    private String departmentTitle;

    @JsonProperty
    @AssertTrue(message = "The Department should exist")
    private Boolean isActive;

    @PastOrPresent(message = "The date of Department creation cannot be in future")
    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdAt;


    private Integer number;
}


