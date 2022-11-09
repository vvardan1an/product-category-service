package com.example.restexample.endpoint;

import com.example.restexample.model.Book;
import com.example.restexample.model.BookLanguage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookEndPoint {

    List<Book> books = List.of(
            new Book(1, "book1", "author1", 250, BookLanguage.EN),
            new Book(2, "book2", "author2", 300, BookLanguage.RU),
            new Book(3, "book3", "author3", 200, BookLanguage.AM)
    );

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int id){
        for (Book book : books) {
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

}
