package booksmanager.service.impl;

import booksmanager.dao.BookDao;
import booksmanager.model.Book;
import booksmanager.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Transactional
    public Book getBookById(int id) {
        return bookDao.getById(id);
    }

    @Transactional
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Transactional
    public void deleteBookById(int id) {
        bookDao.deleteBook(id);
    }

    @Transactional
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Transactional
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}
