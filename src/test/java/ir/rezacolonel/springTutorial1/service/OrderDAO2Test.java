package ir.rezacolonel.springTutorial1.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDAO2Test {

    @Autowired
    OrderDAO2 orderDAO2;
    @Test
    void updateTitle2() {
        orderDAO2.findAll().forEach(System.out::println);
    }
}