package com.example.teacher_project.Model;

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
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "should be filled")
    @Column(columnDefinition = "varchar(30) not null")
    @Size(min = 4, message = "name must be more than 4 character")
    private String name;
    @OneToOne(cascade =CascadeType.ALL,mappedBy = "store")
    @PrimaryKeyJoinColumn
    Location location;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "books")
    private Set<Book> books;

    @ManyToMany(mappedBy = "stores")
    private Set<Customer> customers;




}
