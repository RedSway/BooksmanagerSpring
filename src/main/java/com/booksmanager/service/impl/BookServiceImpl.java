package com.booksmanager.service.impl;

import com.booksmanager.dao.BookDao;
import com.booksmanager.model.Book;
import com.booksmanager.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public Book getBookById(int id) {
        return bookDao.getById(id);
    }

    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    public void deleteBookById(int id) {
        bookDao.deleteBook(id);
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}
