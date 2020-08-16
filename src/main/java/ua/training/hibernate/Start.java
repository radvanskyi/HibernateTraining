package ua.training.hibernate;

import org.hibernate.Session;
import org.jboss.logging.Logger;
import ua.training.hibernate.entity.Author;
import ua.training.hibernate.entity.Book;
import ua.training.hibernate.helper.AuthorHelper;
import ua.training.hibernate.helper.BookHelper;


public class Start {

    private static final Logger LOG = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        AuthorHelper authorHelper = new AuthorHelper(session);

//        Author newAuthor = new Author("test");
//        authorHelper.addAuthor(newAuthor);
//        authorHelper.addAuthors();
//
        for (Author author : authorHelper.getAuthorList()) {
            LOG.error(author.getName() + " - " + author.getSecondName());
        }
//
//        for (Book book : new BookHelper(session).getBookList()) {
//            LOG.error("Book - " + book.getBookName());
//        }

        session.close();
    }
}
