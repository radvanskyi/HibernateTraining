package ua.training.hibernate.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Author extends BaseEntity {

    @Column(name = "second_name")
    private String secondName;

    @OneToMany(targetEntity = Book.class, mappedBy = "author")
    private List<Book> bookList = new ArrayList<>();


}
