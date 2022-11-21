package com.example.CoronaApi.controller;

import com.example.CoronaApi.model.Department;
import com.example.CoronaApi.model.GeneralResponse;
import com.example.CoronaApi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/")
    public Collection<Department> getAllDepartment() {
        return departmentRepository.getAllDepartment();
    }

    @GetMapping("/{departmentId}")
    public Department getDepartmentById(@PathVariable("departmentId") String departmentId) {
        return departmentRepository.getDepartmentById(departmentId);
    }

    @PostMapping("/addDepartment")
    public GeneralResponse addDepartment(@RequestBody Department department) {
        return departmentRepository.addDepartment(department);
    }

    @DeleteMapping("delete/{departmentId}")
    public GeneralResponse deleteDepartment(@PathVariable("departmentId") String departmentId){
        return departmentRepository.deleteDepartment(departmentId);
    }

}
