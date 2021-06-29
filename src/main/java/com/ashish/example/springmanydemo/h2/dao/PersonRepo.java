package com.ashish.example.springmanydemo.h2.dao;

import com.ashish.example.springmanydemo.h2.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person,Integer> {

    List<Person> findByGender(String gender);

    List<Person> findByPidGreaterThan(Integer pid);

    @Query("from Person where gender=?1 order by pname")
    List<Person> findByGenderWithOrderName(String gender);

}
