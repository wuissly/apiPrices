package api.challenge.apiPrices.application.service;


import api.challenge.apiPrices.domain.model.Price;

public interface PriceService {
    Price getPrice(String date, Integer productId, Long brandId);

}
