package ua.training.hibernate;

import org.jboss.logging.Logger;
import ua.training.hibernate.helper.AuthorHelper;
import ua.training.hibernate.helper.BookHelper;


public class Start {

    private static final Logger LOG = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) {

        AuthorHelper authorHelper = new AuthorHelper();
        BookHelper bookHelper = new BookHelper();

        authorHelper.getAuthorList();

    }
}
