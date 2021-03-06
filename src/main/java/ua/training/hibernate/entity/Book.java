package ua.training.hibernate.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity {

    @ManyToOne
    @JoinColumn
    private Author author;

    @OneToMany(targetEntity = Reader.class, mappedBy = "book")
    private Set<Reader> readers = new HashSet<>();

}
