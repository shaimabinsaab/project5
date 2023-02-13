package com.example.teacher_project.Repositry;

import com.example.teacher_project.Model.Customer;
import com.example.teacher_project.Model.Location;
import com.example.teacher_project.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreReositry extends JpaRepository<Store,Integer> {
    Store findStoreById(Integer id);

    Store findAllById(Integer id);
}
