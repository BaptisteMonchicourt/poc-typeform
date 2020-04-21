package lu.intech.poc_typeform;

import lu.intech.poc_typeform.configurations.MvcConfig;
import lu.intech.poc_typeform.services.TFResponseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ MvcConfig.class })
public class PocTypeFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocTypeFormApplication.class, args);
	}

}
