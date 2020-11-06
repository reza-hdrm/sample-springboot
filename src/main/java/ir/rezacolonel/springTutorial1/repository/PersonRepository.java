package ir.rezacolonel.springTutorial1.repository;

import ir.rezacolonel.springTutorial1.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface PersonRepository extends JpaRepository<Persons, Long> {
    @Modifying
    @Transactional
    @Query("update Persons set firstName=?1")
    int updatePersonByFirstName(String firstName,Long id);
}
