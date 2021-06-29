package com.ashish.example.springmanydemo.datarest.dao;

import com.ashish.example.springmanydemo.datarest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employees",path ="employees")
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
