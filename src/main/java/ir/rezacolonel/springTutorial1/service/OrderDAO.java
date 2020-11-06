package ir.rezacolonel.springTutorial1.service;

import ir.rezacolonel.springTutorial1.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;


@Service
public class OrderDAO {

    private JdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;

    @Autowired
    public OrderDAO(JdbcTemplate jdbcTemplate, PlatformTransactionManager platformTransactionManager) {
        this.jdbcTemplate = jdbcTemplate;
        transactionTemplate = new TransactionTemplate(platformTransactionManager);
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transactionTemplate.setTimeout(30);
    }

    //programmatic Transaction
    public void updateTitle(Long postId, String title) {
        Boolean execute = transactionTemplate.execute(transactionStatus -> {
            int affected = jdbcTemplate.update("update posts set title = ? where id = ?;", title, postId);
            return affected > 0;
        });
    }

    //Declarative Transaction Management
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, timeout = 40)
    public void updateTitle2(Long postId, String title) throws ServiceException {
        int affected = jdbcTemplate.update("update posts set title = ? where id = ?;", title, postId);
        if (affected <= 0)
            throw new ServiceException("The Order ID does not exist");
    }
}
