package ibm.com.ibmdemoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class IbmDemoApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(IbmDemoApiApplication.class, args);
	}

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("IBM Demo API")
						.description("Demo API Documentation")
						.version("1.0")
						.contact(new Contact()
								.name("IBM")
								.email("Raphael.Li@ibm.com")
								.url("https://www.ibm.com"))
						.license(new License()
								.name("Apache 2.0")
								.url("http://www.apache.org/licenses/LICENSE-2.0.html"))
				);
	}
}