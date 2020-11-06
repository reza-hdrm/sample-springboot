package ir.rezacolonel.springTutorial1;

import ir.rezacolonel.springTutorial1.service.EmployeeDAD;
import ir.rezacolonel.springTutorial1.service.PersonDAO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class SpringTutorial1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = run(SpringTutorial1Application.class, args);

       /* PersonDAO personDAO = context.getBean(PersonDAO.class);
        personDAO.doSomething();

        EmployeeDAD employeeDAD = context.getBean(EmployeeDAD.class);
        employeeDAD.doSomething();

        System.out.println(personDAO.parseDate("1399/05/29"));*/

    }
}
