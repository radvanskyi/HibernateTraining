package ua.training.hibernate.helper;

import org.hibernate.Session;
import ua.training.hibernate.entity.Author;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
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
        Selection[] selections = {root.get("name"), root.get("secondName")};

        criteriaQuery.select(criteriaBuilder.construct(Author.class, selections));

        return session.createQuery(criteriaQuery)
                .getResultList();
    }

    public Author addAuthor(Author author) {
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();

        return author;
    }

    public void addAuthors() {
        session.beginTransaction();
        for (int i = 0; i < 200; i++) {
            if (i % 10 == 0) {
                session.flush();
            }
            Author author = new Author("name" + i, "secondName" + i);
            session.save(author);
        }
        session.getTransaction().commit();
    }

    public Author getAuthor(String name) {
        return null;
    }

}
