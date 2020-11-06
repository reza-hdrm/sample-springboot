package ir.rezacolonel.springTutorial1.repository;

import ir.rezacolonel.springTutorial1.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts,Long> {
    List<Posts> findByTitle (String title);
    List<Posts> findByTitleAndId (String title,Long id);
}
