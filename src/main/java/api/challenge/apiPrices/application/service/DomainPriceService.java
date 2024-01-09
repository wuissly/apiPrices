package api.challenge.apiPrices.application.service;


import api.challenge.apiPrices.domain.model.Price;
import api.challenge.apiPrices.domain.ports.PriceRepository;
import api.challenge.apiPrices.infrastructure.exception.InvalidDateException;
import api.challenge.apiPrices.infrastructure.exception.PriceNotFoundException;
import api.challenge.apiPrices.infrastructure.repository.h2.PriceEntity;
import api.challenge.apiPrices.infrastructure.rest.mapper.PriceMapper;
import com.challenge.plataforma.infrastructure.utils.Constants;
import lombok.SneakyThrows;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.util.Optional;

public class DomainPriceService implements PriceService {

    private PriceMapper mapper= Mappers.getMapper(PriceMapper.class);

    private final PriceRepository priceRepository;

    public DomainPriceService(final PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
    @SneakyThrows
    public Price getPrice(String date, Integer productId, Long brandId) {
        Optional<PriceEntity> priceOptional = Optional.ofNullable(priceRepository.getPrice(brandId, productId, parseToTimestamp(date)));
        if (!priceOptional.isPresent())
            throw new PriceNotFoundException(Constants.CODE_NOT_FOUND,Constants.DESCRIPTION_NOT_FOUND);
        Price priceResponse= mapper.priceEntityToPriceResponse(priceOptional);
        return  priceResponse;
    }

    @SneakyThrows
    private Timestamp parseToTimestamp(String fechaIn) {

        Timestamp fechaOut = null;
        try {
            fechaOut = Timestamp.valueOf(fechaIn);
        } catch (IllegalArgumentException e) {
            throw new InvalidDateException(Constants.INVALID_DATE,Constants.DESCRIPTION_INVALID_DATE);
        }
        return fechaOut;
    }
}
