package com.ashish.example.springmanydemo.embedded.daorest;


import com.ashish.example.springmanydemo.embedded.model.Customer;
import com.ashish.example.springmanydemo.embedded.model.LoginId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "customers",path ="customers")
public interface CustomerRepo extends JpaRepository<Customer, LoginId> {

    Optional<Customer> findByLoginId(@RequestBody LoginId loginId);
}
