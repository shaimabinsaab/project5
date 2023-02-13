package com.example.teacher_project.Repositry;

import com.example.teacher_project.Model.Book;
import com.example.teacher_project.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepositry extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);

    Book findBookByNameEquals(String name);

    List<Book> findAllByGenreEquals(String genre);
}
