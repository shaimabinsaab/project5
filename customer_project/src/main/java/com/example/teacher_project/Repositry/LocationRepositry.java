package com.example.teacher_project.Repositry;

import com.example.teacher_project.Model.Customer;
import com.example.teacher_project.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepositry extends JpaRepository<Location,Integer> {

    Location findLocationById(Integer id);

    Location findAllById(Integer id);
}
