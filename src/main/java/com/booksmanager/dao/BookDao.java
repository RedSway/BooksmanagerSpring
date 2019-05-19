package com.booksmanager.dao;

import com.booksmanager.model.Book;

import java.util.List;

public interface BookDao {
    Book getById(int id);
    void addBook(Book book) ;
    void deleteBook(int id);
    void updateBook(Book book);
    List<Book> getAllBooks();
}
