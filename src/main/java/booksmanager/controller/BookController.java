package booksmanager.controller;

import booksmanager.model.Book;
import booksmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getAllBooks(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());

        return "books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        if (book.getId() == 0) {
            bookService.addBook(book);
        } else {
            bookService.updateBook(book);
        }

        return "redirect:/books";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBookById(id);

        return "redirect:/books";
    }

    @RequestMapping("/update/{id}")
    public String updateBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("bookList", bookService.getAllBooks());

        return "books";
    }
}
