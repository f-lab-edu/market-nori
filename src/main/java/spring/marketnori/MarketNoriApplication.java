package spring.marketnori;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@PropertySource("classpath:/keys.properties")
@EnableJpaAuditing
public class MarketNoriApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketNoriApplication.class, args);
	}

}
