package com.booksmanager.controller;

import com.booksmanager.model.Book;
import com.booksmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String getAllBooks(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());

        return "books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        if (book.getId() == 0) {
            bookService.addBook(book);
            System.out.println("Add book");
        } else {
            bookService.updateBook(book);
            System.out.println("Update book");
        }

        return "redirect:/books";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBookById(id);

        return "redirect:/books";
    }

    @RequestMapping("update/{id}")
    public String updateBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("bookList", bookService.getAllBooks());

        return "books";
    }

}
