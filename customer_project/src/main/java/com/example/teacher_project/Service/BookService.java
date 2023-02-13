package com.example.teacher_project.Service;

import com.example.teacher_project.Exeption.Api;
import com.example.teacher_project.Model.Book;
import com.example.teacher_project.Model.Store;
import com.example.teacher_project.Repositry.BookRepositry;
import com.example.teacher_project.Repositry.StoreReositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepositry bookRepositry;
    private final StoreReositry storeReositry;
    public List<Book> getBook(){
        return bookRepositry.findAll();
    }

    public void addBook(Book book){
        bookRepositry.save(book);
    }

    public void UpdateBook(Integer id,Book book){
        Book m=bookRepositry.findBookById(id);

        if(m==null){
            throw new Api("this id is not here");
        }


    }
    public void deleteBook(Integer id) {
        Book m = bookRepositry.findBookById(id);

        if (m == null) {
            throw new Api("id not here");

        }

        bookRepositry.delete(m);

    }
    public void assign(Integer b_id,Integer s_id){
        Book book= bookRepositry.findBookById(b_id);
        Store store=storeReositry.findStoreById(s_id);
        if (book==null||store==null){
            throw new Api("id not here");
        }
        book.setStore(store);
    }

    public String returnBook(Integer id){
        Book book= bookRepositry.findBookById(id);
        Store store=storeReositry.findStoreById(book.getStore().getId());
        if (book==null ||store==null ) {
            throw new Api("Id is not found");
        }
        else return book.getName();
    }
    public Integer booksAvailableForBook(Integer bookId){
        Book book = bookRepositry.findBookById(bookId);
        return book.getBookcount();
    }
    public Book getBookByName(String name){
        Book book = bookRepositry.findBookByNameEquals(name);

        if (book == null)
            throw new Api("Book not found");
        return book;
    }
    public List<Book> getBooksByGenre(String genre){
        return bookRepositry.findAllByGenreEquals(genre);
    }





}
