package ua.training.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, Long> id;
	public static volatile SingularAttribute<Book, Long> authorId;
	public static volatile SingularAttribute<Book, String> bookName;

}

