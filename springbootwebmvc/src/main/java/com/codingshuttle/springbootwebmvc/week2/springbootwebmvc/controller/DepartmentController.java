package com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.controller;

import com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.dto.DepartmentDTO;
import com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.exception.ResourceNotFoundException;
import com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.services.DepartmentServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentServices departmentServices;

    public DepartmentController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @GetMapping(path = "/departmentId")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable(name = "departmentid") Long Id) {
        Optional<DepartmentDTO> departmentDTO = departmentServices.getDepartmentById(Id);
        return departmentDTO.
                map(departmentDTO1 -> ResponseEntity.ok(departmentDTO1)).
                orElseThrow(() -> new ResourceNotFoundException("Department not found with " + Id));
    }

    @GetMapping(path ="")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(@RequestParam(required = false) String departmentTitle) {
        return ResponseEntity.ok(departmentServices.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO departmentTitle) {
        DepartmentDTO savedDepartmentname = departmentServices.createNewDepartment(departmentTitle);
        return new ResponseEntity<>(savedDepartmentname, HttpStatus.CREATED);
    }

    @PutMapping(path = "/departmentId")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody @Valid DepartmentDTO departmentDTO, @PathVariable Long Id) {
        return ResponseEntity.ok(departmentServices.updateDepartmentById(Id, departmentDTO));
    }


    @DeleteMapping(path = "/departmentId")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long Id) {
        boolean gotDeleted = departmentServices.deleteDepartmentById(Id);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }


    @PatchMapping(path = "/departmentId")
    public ResponseEntity<DepartmentDTO> updatePartialDepartmentById(@RequestBody Map<String,Object> updates, @PathVariable Long Id) {

       DepartmentDTO departmentDTO = departmentServices.updatePartialDepartmentById(Id,updates);
       if(departmentDTO==null) return ResponseEntity.notFound().build();
       return ResponseEntity.ok(departmentDTO);
    }
}