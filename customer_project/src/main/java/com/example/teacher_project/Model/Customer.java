package com.example.teacher_project.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "should be filled")
    @Column(columnDefinition = "varchar(30) not null")
    @Size(min = 4,message = "name must be more than 4 character")
    private String name;
    private int phone;
    private String email;

    @ManyToMany
    @JsonIgnore
    private Set<Store> stores;

    }
