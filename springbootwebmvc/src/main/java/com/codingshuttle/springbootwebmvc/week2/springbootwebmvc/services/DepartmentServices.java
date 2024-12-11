package com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.services;

import com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.dto.DepartmentDTO;
import com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.entities.DepartmentEntity;
import com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.exception.ResourceNotFoundException;
import com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;

import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServices {
private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentServices(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }



    public Optional<DepartmentDTO> getDepartmentById(Long Id){

        return departmentRepository.
                findById(Id).
                map(departmentEntity-> modelMapper.map(departmentEntity,DepartmentDTO.class));

}

public List<DepartmentDTO> getAllDepartments(){
List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
return departmentEntities.
        stream().
        map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDTO.class)).
        collect(Collectors.toList());

}

    public DepartmentDTO createNewDepartment(DepartmentDTO departmentTitle) {
     DepartmentEntity tosaveEntity = modelMapper.map(departmentTitle,DepartmentEntity.class);
     DepartmentEntity savedEntity = departmentRepository.save(tosaveEntity);
     return modelMapper.map(savedEntity,DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(Long Id, DepartmentDTO departmentDTO) {

            isExistByDeparmentId(Id);
          DepartmentEntity departmentEntity = modelMapper.map(departmentDTO,DepartmentEntity.class);
          departmentEntity.setId(Id);
          DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity,DepartmentDTO.class);

    }

    public void isExistByDeparmentId(Long Id) {
        boolean exist = departmentRepository.existsById(Id);
        if(!exist) throw new ResourceNotFoundException("Resource not found with id "+ Id);
    }


    public boolean deleteDepartmentById(Long Id){
        isExistByDeparmentId(Id);
        departmentRepository.deleteById(Id);
        return true;
    }

   public DepartmentDTO updatePartialDepartmentById(Long Id, Map<String,Object> updates){
       isExistByDeparmentId(Id);
       DepartmentEntity departmentEntity = departmentRepository.findById(Id).get();
       updates.forEach((field,value)->{
           Field fieldtobeUpdated = ReflectionUtils.findRequiredField(DepartmentEntity.class,field);
           fieldtobeUpdated.setAccessible(true);
           ReflectionUtils.setField(fieldtobeUpdated,departmentEntity,value);
       });
       return modelMapper.map(departmentRepository.save(departmentEntity),DepartmentDTO.class);
   }


}
