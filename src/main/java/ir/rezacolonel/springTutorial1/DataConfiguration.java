package ir.rezacolonel.springTutorial1;

import com.ibm.icu.text.SimpleDateFormat;
import ir.rezacolonel.springTutorial1.service.EmployeeDAD;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Locale;


@Configuration
@EnableJpaRepositories(basePackages = "ir.rezacolonel.springTutorial1.repository")
public class DataConfiguration {

}
