package com.example.teacher_project.Repositry;

import com.example.teacher_project.Model.Customer;
import com.example.teacher_project.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositry extends JpaRepository<Customer,Integer> {

    Customer findCustomerById(Integer id);


}
