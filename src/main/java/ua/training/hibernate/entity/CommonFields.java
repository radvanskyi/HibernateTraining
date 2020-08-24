package ua.training.hibernate.entity;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString(of = "name", includeFieldNames = false)
public class CommonFields {

    private String name;
}
