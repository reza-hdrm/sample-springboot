package ir.rezacolonel.springTutorial1.repository;

import ir.rezacolonel.springTutorial1.model.Posts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void testFindById() throws Exception {
        //postRepository.findAll().forEach(System.out::println);
        postRepository.findByTitle("reza is java programmer").forEach(System.out::println);
        postRepository.findAll(Sort.by("title").ascending().and(Sort.by("id").descending()));

        Page<Posts> all1 = postRepository.findAll(PageRequest.of(2, 10));
        all1.forEach(System.out::println);

        Posts posts = new Posts();
        posts.setTitle("the King");

        postRepository.findAll(Example.of(posts));
    }
}