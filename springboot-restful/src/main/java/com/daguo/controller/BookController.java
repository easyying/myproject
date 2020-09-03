package com.daguo.controller;

import com.daguo.bean.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookController {
    private List<Book> books = new ArrayList<Book>();

    @PostMapping("/book")
    public ResponseEntity<List<Book>> addBook(@RequestBody Book book){//@RequestBody:可以将HttpRequestbody中的JSON类型数据反序列化为合适的Java类型。
        books.add(book);
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/book/{id}")//http://localhost:8086/api/book/1   get也行
    public ResponseEntity deleteBookById(@PathVariable("id") int id){//@PathVariable 取url地址中的参数
        books.remove(id);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book")// http://localhost:8086/api/book?name=曹雪芹
    public ResponseEntity getBookByName(@RequestParam("name") final String name){
        //List<Book> results = books.stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
        return ResponseEntity.ok(books);
    }
}
