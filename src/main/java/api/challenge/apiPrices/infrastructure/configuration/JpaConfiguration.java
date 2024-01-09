package api.challenge.apiPrices.infrastructure.configuration;

import api.challenge.apiPrices.infrastructure.adapters.PriceRepositoryPersist;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackageClasses = PriceRepositoryPersist.class)
public class JpaConfiguration {
}
