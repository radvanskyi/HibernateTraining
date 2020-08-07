package ua.training.hibernate.helper;

import org.hibernate.Session;
import ua.training.hibernate.entity.Book;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookHelper {

    private Session session;

    public BookHelper(Session session) {
        this.session = session;
    }

    public List<Book> getBookList() {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root);

        Query query = session.createQuery(criteriaQuery);
        List<Book> bookList = query.getResultList();

        return bookList;
    }

}
