package ir.rezacolonel.springTutorial1.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persons {

    @Id
    private Long id;
    @Column
    private String firstName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank
    @Size(min = 4, max = 20,message = "First Name must be between 4 and 20")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
