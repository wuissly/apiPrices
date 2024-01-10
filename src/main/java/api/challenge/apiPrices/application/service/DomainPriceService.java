package api.challenge.apiPrices.application.service;


import api.challenge.apiPrices.domain.model.Price;
import api.challenge.apiPrices.domain.ports.PriceRepository;
import api.challenge.apiPrices.infrastructure.exception.InvalidDateException;
import api.challenge.apiPrices.infrastructure.exception.PriceNotFoundException;
import api.challenge.apiPrices.infrastructure.repository.h2.PriceEntity;
import api.challenge.apiPrices.infrastructure.rest.mapper.PriceMapper;
import api.challenge.apiPrices.infrastructure.utils.Constants;
import lombok.SneakyThrows;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

public class DomainPriceService implements PriceService {

    private PriceMapper mapper= Mappers.getMapper(PriceMapper.class);

    private final PriceRepository priceRepository;

    public DomainPriceService(final PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
    @SneakyThrows
    public Price getPrice(String date, Integer productId, Long brandId) {
        List<PriceEntity> listPriceEntity = priceRepository.getPrice(brandId, productId, parseToLocaldatetime(date));
        Optional<PriceEntity> priceOptional = listPriceEntity.stream().findFirst();
        if (!priceOptional.isPresent())
            throw new PriceNotFoundException(Constants.CODE_NOT_FOUND,Constants.DESCRIPTION_NOT_FOUND);
        Price priceResponse= mapper.priceEntityToPriceResponse(priceOptional);
        return  priceResponse;
    }


    @SneakyThrows
    private LocalDateTime parseToLocaldatetime(String dateIn) {

        LocalDateTime dateOut = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            dateOut = LocalDateTime.parse(dateIn, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateException(Constants.INVALID_DATE,Constants.DESCRIPTION_INVALID_DATE);
        }
        return dateOut;
    }
}
