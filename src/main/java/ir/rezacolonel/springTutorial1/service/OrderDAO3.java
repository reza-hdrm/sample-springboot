package ir.rezacolonel.springTutorial1.service;

import ir.rezacolonel.springTutorial1.exception.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class OrderDAO3 {

    @PersistenceContext
    private EntityManager entityManager;

    //Declarative Transaction Management
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, timeout = 40)
    public void updateTitle(Long postId, String title) throws ServiceException {
        entityManager.createQuery("update Posts set title=:pTitle where id =:pId")
                .setParameter("pTitle", title)
                .setParameter("pId", postId)
                .executeUpdate();
    }
}
