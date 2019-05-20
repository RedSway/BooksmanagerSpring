package com.booksmanager.dao.impl;

import com.booksmanager.dao.BookDao;
import com.booksmanager.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Book getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Book book = session.get(Book.class, id);
        transaction.commit();
        session.close();
        return book;
    }

    public void addBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public void deleteBook(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Book book = session.load(Book.class, id);
        session.delete(book);
        transaction.commit();
        session.close();
    }

    public void updateBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(book);
        transaction.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Book> bookList = session.createQuery("FROM Book").list();
        transaction.commit();
        session.close();
        return bookList;
    }
}