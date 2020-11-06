package ir.rezacolonel.springTutorial1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orders {

    @Id
    private Long id;
    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
