package ir.rezacolonel.springTutorial1.service;

import ir.rezacolonel.springTutorial1.exception.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDAO3Test {

    @Autowired
    OrderDAO3 orderDAO3;
    @Test
    void updateTitle2() throws ServiceException {
        orderDAO3.updateTitle(2l,"reza is java programmer");
    }
}