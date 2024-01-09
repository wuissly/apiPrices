package api.challenge.apiPrices.application;

import api.challenge.apiPrices.infrastructure.adapters.PriceRepositoryH2;
import api.challenge.apiPrices.infrastructure.adapters.PriceRepositoryPersist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "api.challenge.apiPrices")
@EntityScan(basePackages={"api.challenge.apiPrices.infrastructure.repository.h2"})
@EnableJpaRepositories(basePackages={"api.challenge.apiPrices.infrastructure.adapters"})
public class ApiPricesApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiPricesApplication.class, args);
	}




}
