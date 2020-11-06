package ir.rezacolonel.springTutorial1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CalculateService {

    @Value("#{personDAO.parseDate('1399/05/30')}")
    private Date date;
    
    @Autowired
    @Qualifier("insuranceCalculation96")
    private InsuranceCalculation insuranceCalculation;

}
