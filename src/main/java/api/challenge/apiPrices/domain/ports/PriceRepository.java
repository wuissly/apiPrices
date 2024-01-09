package api.challenge.apiPrices.domain.ports;

import api.challenge.apiPrices.infrastructure.repository.h2.PriceEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface PriceRepository {

    List<PriceEntity> getPrice (Long brandId, Integer productId, LocalDateTime date);
}
