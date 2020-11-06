package ir.rezacolonel.springTutorial1.repository;

import ir.rezacolonel.springTutorial1.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<Orders,Long> {

}
