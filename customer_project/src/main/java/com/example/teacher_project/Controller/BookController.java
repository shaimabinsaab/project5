package com.example.teacher_project.Controller;

import com.example.teacher_project.Model.Book;
import com.example.teacher_project.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;
    @GetMapping("/get")
    public ResponseEntity getBook(){
        List<Book> Books=bookService.getBook();
        return ResponseEntity.status(200).body(Books);
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book Books){
        bookService.addBook(Books);
        return ResponseEntity.status(200).body("Book added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @Valid @RequestBody Book Books) {
        bookService.UpdateBook(id, Books);
        return ResponseEntity.status(200).body("Book updated");

    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletBook(@PathVariable Integer id){
        bookService.deleteBook(id);

        return ResponseEntity.status(200).body("Book deleted");


    }
    @PutMapping("/assign/{bookId}/store/{storeId}")
    public ResponseEntity assignStoreToBook(@PathVariable Integer bookId, @PathVariable Integer storeId){
        bookService.assign(bookId, storeId);
        return ResponseEntity.status(200).body("Store with id: "+storeId+", was assigned to book: "+bookId);
    }

    @GetMapping("/get/{bookId}/count")
    public ResponseEntity getBookCount(@PathVariable Integer bookId){
        return ResponseEntity.status(200).body(bookService.booksAvailableForBook(bookId));
    }

    @GetMapping("/get/name")
    public ResponseEntity getBookByName(@RequestBody Book book){
        return ResponseEntity.status(200).body(bookService.getBookByName(book.getName()));
    }

    @GetMapping("/get/genre")
    public ResponseEntity getBooksByGenre(@RequestBody Book book){
        return ResponseEntity.status(200).body(bookService.getBooksByGenre(book.getGenre()));
    }

}
