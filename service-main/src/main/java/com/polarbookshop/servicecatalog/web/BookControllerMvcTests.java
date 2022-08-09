package com.polarbookshop.servicecatalog.web;

import com.polarbookshop.servicecatalog.controller.BookController;
import com.polarbookshop.servicecatalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


//@WebMvcTest(BookController.class)
@EnableWebMvc
public class BookControllerMvcTests {
    @Autowired
    private MockMvc mockMvc;
//    @MockBean
    private BookService bookService;

}
