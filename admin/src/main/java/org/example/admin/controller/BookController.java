package org.example.admin.controller;

import jakarta.annotation.Resource;
import org.example.admin.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {

    @Resource
    private BookService bookService;
}
