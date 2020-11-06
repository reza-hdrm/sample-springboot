package ir.rezacolonel.springTutorial1.model;

import javax.persistence.*;

@Entity
public class Posts {
    @Id
    private long id;
    @Column
    private String title;

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
