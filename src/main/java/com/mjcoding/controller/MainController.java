package com.mjcoding.controller;

import com.mjcoding.dto.ResponseDto;
import com.mjcoding.entity.Books;
import com.mjcoding.entity.IssueBooks;
import com.mjcoding.entity.Students;
import com.mjcoding.service.BooksServiceImpl;
import com.mjcoding.service.IssueBookServiceImpl;
import com.mjcoding.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private BooksServiceImpl bookService;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private IssueBookServiceImpl issueBookservice;


    @RequestMapping(value = "/book/insertion", method = RequestMethod.POST)
    public Books saveBooks(@RequestBody Books books) {
        return bookService.bookInsertion(books);
    }

    @RequestMapping(value = "/save/students", method = RequestMethod.POST)
    public Students saveBooks(@RequestBody Students students) {
        return studentService.saveStudents(students);
    }

    @RequestMapping(value = "/issuebooks", method = RequestMethod.POST)
    public IssueBooks issueBooks(@RequestBody IssueBooks issuedBooks) {
        return issueBookservice.issueBooks(issuedBooks);
    }


    @RequestMapping(value = "/getBooks", method = RequestMethod.GET)
    @ResponseBody
    public List<ResponseDto> getAllBooks() {
        List<ResponseDto> dtoList = bookService.getAll();
        return dtoList;
    }

    //find by bookId
    @RequestMapping(value = "/book/findById/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> bookFindById(@PathVariable Long id) {
        ResponseDto books = bookService.findById(id);
        if (books == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(books);
        }
    }

    //find by book Title
    @RequestMapping(value = "/book/findByTitle/{title}", method = RequestMethod.GET)
    public ResponseDto findByTitle(@PathVariable String title) {
        return bookService.findByTitle(title);
    }


//    //Find by Author
//    @RequestMapping(value = "/book/findByAuthor/{author}", method = RequestMethod.GET)
//    public Books findByAuthor(@PathVariable String author) {
//        return bookService.findByAuthor(author);
//    }
//
//
//    //Get all issued books
//    @RequestMapping(value = "/book/issued", method = RequestMethod.GET)
//    public List<IssuedBooks> getAll() {
//        return issueBookservice.getAll();
//    }


}
