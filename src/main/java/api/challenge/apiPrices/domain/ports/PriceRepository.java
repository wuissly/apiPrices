package api.challenge.apiPrices.domain.ports;

import api.challenge.apiPrices.infrastructure.repository.h2.PriceEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public interface PriceRepository {

    PriceEntity getPrice (Long brandId, Integer productId, Timestamp date);
}
