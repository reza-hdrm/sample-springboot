package ir.rezacolonel.springTutorial1;

import ir.rezacolonel.springTutorial1.service.CalculateService;
import ir.rezacolonel.springTutorial1.service.EmployeeDAD;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringTutorial1ApplicationTests {

    @Autowired
    EmployeeDAD employeeDAD;

    @Test
    void contextLoads() {

    }
    @Test
     public void testAspect(){
        String s= employeeDAD.callThisMethod();
        System.out.println(s);
    }
}
