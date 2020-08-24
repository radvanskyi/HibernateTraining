package ua.training.hibernate.helper;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import ua.training.hibernate.HibernateUtil;
import ua.training.hibernate.entity.Book;

public class BookHelper {

    public List<Book> getBookList() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Statistics statistics = sessionFactory.getStatistics();
        statistics.clear();
        statistics.setStatisticsEnabled(true);

        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root);
        statistics.logSummary();

        return session.createQuery(criteriaQuery).getResultList();
    }

}
