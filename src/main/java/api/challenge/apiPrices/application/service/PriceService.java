package api.challenge.apiPrices.application.service;


import api.challenge.apiPrices.domain.model.Price;

public interface PriceService {
    Price getPrice(String fecha, Integer productId, Long brandId);

}
