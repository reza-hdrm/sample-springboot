package ir.rezacolonel.springTutorial1.service;

import ir.rezacolonel.springTutorial1.exception.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDAOTest {
    @Autowired
    OrderDAO orderDAO;

    @Test
    void updateOrder1() {
        orderDAO.updateTitle(2l, "reza is the best");
    }
    @Test
    void updateOrder2() throws ServiceException {
        orderDAO.updateTitle2(2l, "reza is the best in world2");
    }
}