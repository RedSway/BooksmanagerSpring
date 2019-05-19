package booksmanager.dao.impl;



import booksmanager.dao.BookDao;
import booksmanager.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Book getById(int id) {
        return sessionFactory.openSession().get(Book.class, id);
    }

    public void addBook(Book book) {
        Session session = sessionFactory.openSession();
        session.save(book);
        session.close();
    }

    public void deleteBook(int id) {
        Session session = sessionFactory.openSession();
        Book book = session.load(Book.class, id);
        session.delete(book);
        session.close();
    }

    public void updateBook(Book book) {
        Session session = sessionFactory.openSession();
        session.update(book);
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks() {
        Session session = sessionFactory.openSession();
        return (List<Book>) session.createQuery("FROM Book").list();
    }
}
