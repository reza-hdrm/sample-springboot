package ir.rezacolonel.springTutorial1;

import com.ibm.icu.text.SimpleDateFormat;
import ir.rezacolonel.springTutorial1.service.EmployeeDAD;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.util.Locale;


@Configuration
public class AppConfiguration {

    @Bean(initMethod = "init", destroyMethod = "destroyed")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public EmployeeDAD employeeDAD() {
        return new EmployeeDAD();
    }

    @Bean
    public SimpleDateFormat persianDateFormat() {
        return new SimpleDateFormat("yyyy/MM/dd", new Locale("fa", "IR"));
    }

    @Bean
    @Primary
    public SimpleDateFormat gregorianDateFormat() {
        return new SimpleDateFormat("yyyy/MM/dd");
    }
}
