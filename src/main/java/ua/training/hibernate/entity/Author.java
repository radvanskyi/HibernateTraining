package ua.training.hibernate.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraphs({
        @NamedEntityGraph(name = "author.books", attributeNodes = {
                @NamedAttributeNode(value = "books")
        }),
        @NamedEntityGraph(name = "author.books.readers", attributeNodes = {
                @NamedAttributeNode(value = "books", subgraph = "book.readers")
        }, subgraphs = {
                @NamedSubgraph(name = "book.readers", attributeNodes = {
                        @NamedAttributeNode(value = "readers")
                })
        })
})
public class Author extends BaseEntity {

    @Column(name = "second_name")
    private String secondName;

    @OneToMany(targetEntity = Book.class, mappedBy = "author")
    private Set<Book> books = new HashSet<>();

}
