package ir.rezacolonel.springTutorial1.service;

import com.ibm.icu.text.SimpleDateFormat;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.text.ParseException;
import java.util.Date;

@Component
public class PersonDAO implements InitializingBean {

    private SimpleDateFormat persianDateFormat;

    @Autowired
    public PersonDAO(@Qualifier("persianDateFormat") SimpleDateFormat persianDateFormat) {
        this.persianDateFormat = persianDateFormat;
    }

    public PersonDAO() {
        System.out.println("PersonDAO Created");
    }

    @PostConstruct
    public void init() {
        System.out.println("PersonDAO initialized");
    }

    @PreDestroy
    public void destroyed() {
        System.out.println("PersonDAO destroyed");
    }

    public void doSomething() {
        System.out.println("Salam " + getClass().getName());
    }

    public Date parseDate(String date) {
        try {
            return persianDateFormat.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("PersonDAO initialized after Properties Set");
    }
}
