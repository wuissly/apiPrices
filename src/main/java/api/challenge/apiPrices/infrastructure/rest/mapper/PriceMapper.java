package api.challenge.apiPrices.infrastructure.rest.mapper;

import api.challenge.apiPrices.domain.model.Price;
import api.challenge.apiPrices.infrastructure.repository.h2.PriceEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(expression = "java(price.get().getBrandId().getId())", target = "brandId")
    @Mapping(expression = "java(price.get().getProductId())", target = "productId")
    @Mapping(expression = "java(price.get().getPriceList())", target = "priceList")
    @Mapping(expression = "java(price.get().getStartDate())", target = "startDate",dateFormat = "yyyy-MM-dd'-'HH.mm.ss")
    @Mapping(expression = "java(price.get().getEndDate())", target = "endDate",dateFormat = "yyyy-MM-dd'-'HH.mm.ss")
    @Mapping(expression = "java(price.get().getPrice())", target = "price",numberFormat = "0.00")
    Price priceEntityToPriceResponse(Optional<PriceEntity> price);

}