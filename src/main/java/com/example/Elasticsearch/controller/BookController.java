package com.example.Elasticsearch.controller;

import com.example.Elasticsearch.pojo.Book;
import com.example.Elasticsearch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public void addBook(@RequestBody Book book){
        bookService.save(book);
    }

    @GetMapping("/getBook/{id}")
    public void getBook(@PathVariable(name = "id") int id){
        Optional<Book> book = bookService.findById(String.valueOf(id));
        System.out.println(book.get().toString());
    }

}
