package ua.training.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Author.class)
public abstract class Author_ extends ua.training.hibernate.entity.BaseEntity_ {

	public static volatile SingularAttribute<Author, String> secondName;
	public static volatile ListAttribute<Author, Book> bookList;

}

