package ua.training.hibernate.helper;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import org.hibernate.Session;
import ua.training.hibernate.HibernateUtil;
import ua.training.hibernate.entity.Author;
import ua.training.hibernate.entity.Author_;

public class AuthorHelper {

    public List<Author> getAuthorList() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.get(Author.class, 1L);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);

        Root<Author> root = criteriaQuery.from(Author.class);
        Selection[] selections = {root.get(Author_.id), root.get(Author_.name)};

        ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class, "name");
        criteriaQuery.select(criteriaBuilder.construct(Author.class, selections)).where(criteriaBuilder.like(root.get(Author_.name), parameter));

        Query query = session.createQuery(criteriaQuery);
        query.setParameter("name", "%1%");

        return (List<Author>) query.getResultList();
    }

    public Author addAuthor(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();

        return author;
    }

    public void addAuthors() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        for (int i = 0; i < 200; i++) {
            if (i % 10 == 0) {
                session.flush();
            }
            Author author = new Author(i, "name" + i, "secondName" + i);
            session.save(author);
        }
        session.getTransaction().commit();
        session.close();
    }

    public Author getAuthor(String name) {
        return null;
    }

    public void delete(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Author author = session.get(Author.class, id);
        session.delete(author);

        session.getTransaction().commit();
        session.close();
    }

    public void deleteGroup() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<Author> criteriaDelete = criteriaBuilder.createCriteriaDelete(Author.class);
        Root<Author> root = criteriaDelete.from(Author.class);

        ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class, "name");
        criteriaDelete.where(criteriaBuilder.like(root.get(Author_.name), parameter));

        Query query = session.createQuery(criteriaDelete);
        query.setParameter("name", "%1%");
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    public void update() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Author> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Author.class);

        Root<Author> root = criteriaUpdate.from(Author.class);
        ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class, "name");
        Expression<Integer> length = criteriaBuilder.length(root.get(Author_.secondName));
        criteriaUpdate.set(root.get(Author_.name), parameter).where(criteriaBuilder.greaterThan(length, 5));

        Query query = session.createQuery(criteriaUpdate);
        query.setParameter("name", "1");
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

}
