package com.booksmanager.service;

import com.booksmanager.model.Book;

import java.util.List;

public interface BookService {
    Book getBookById(int id);
    void addBook(Book book);
    void deleteBookById(int id) ;
    void updateBook(Book book);
    List<Book> getAllBooks();
}
