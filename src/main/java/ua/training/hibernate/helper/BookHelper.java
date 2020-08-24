package ua.training.hibernate.helper;

import org.hibernate.Session;
import ua.training.hibernate.HibernateUtil;
import ua.training.hibernate.entity.Book;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookHelper {

    public List<Book> getBookList() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root);

        return session.createQuery(criteriaQuery).getResultList();
    }

}
