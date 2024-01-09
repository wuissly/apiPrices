package api.challenge.apiPrices.infrastructure.configuration;

import api.challenge.apiPrices.domain.ports.PriceRepository;
import api.challenge.apiPrices.application.service.DomainPriceService;
import api.challenge.apiPrices.application.service.PriceService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class BeanConfiguration {

    @Bean
    PriceService priceService(final PriceRepository priceRepository) {
        return new DomainPriceService(priceRepository);
    }
}