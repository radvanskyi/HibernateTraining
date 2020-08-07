package ua.training.hibernate.helper;

import org.hibernate.Session;
import ua.training.hibernate.entity.Author;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AuthorHelper {

    private Session session;

    public AuthorHelper(Session session) {
        this.session = session;
    }

    public List<Author> getAuthorList() {
        session.get(Author.class, 1L);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);

        Root<Author> root = criteriaQuery.from(Author.class);
        criteriaQuery.select(root);

        return session.createQuery(criteriaQuery)
                .getResultList();
    }

    public Author getAuthor(String name) {
        return null;
    }

}
