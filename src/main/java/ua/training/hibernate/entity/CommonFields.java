package ua.training.hibernate.entity;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class CommonFields {

    String name;
}
