package ua.training.hibernate;

import org.hibernate.Session;
import ua.training.hibernate.entity.Author;
import ua.training.hibernate.entity.Book;
import ua.training.hibernate.helper.AuthorHelper;
import ua.training.hibernate.helper.BookHelper;

public class Start {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        for (Author author : new AuthorHelper(session).getAuthorList()) {
            System.out.println("Author - " + author.getName());
        }

        for (Book book : new BookHelper(session).getBookList()) {
            System.out.println("Book - " + book.getBookName());
        }

        session.close();
        
    }
}
