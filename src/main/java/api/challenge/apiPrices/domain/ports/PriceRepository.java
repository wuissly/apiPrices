package api.challenge.apiPrices.domain.ports;

import api.challenge.apiPrices.infrastructure.repository.h2.PriceEntity;

import java.sql.Timestamp;

public interface PriceRepository {

    PriceEntity getPrice (Long brandId, Integer productId, Timestamp date);
}
