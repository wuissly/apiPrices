package api.challenge.apiPrices.infrastructure.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;


import api.challenge.apiPrices.domain.model.Price;
import api.challenge.apiPrices.infrastructure.repository.h2.GroupEntity;
import api.challenge.apiPrices.infrastructure.repository.h2.PriceEntity;
import org.mapstruct.factory.Mappers;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;
import api.challenge.apiPrices.infrastructure.rest.mapper.PriceMapper;

public class PriceMapperTest {
    
    private final PriceMapper priceMapper = Mappers.getMapper(PriceMapper.class);

    @Test
    public void priceToPriceResponseTest() {
        GroupEntity groupEntity =  GroupEntity.builder().description("Zara").id(1l).build();
        PriceEntity priceEntity = PriceEntity.builder()
                .brandId(groupEntity)
                .productId(35455)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusDays(3))
                .price(9.99)
                .priority(1)
                .curr("EUR")
                .build();

        Optional<PriceEntity> priceOptional = Optional.of(priceEntity);

        Price price = priceMapper.priceEntityToPriceResponse(priceOptional);

        assertEquals(1, price.getBrandId());
        assertEquals(35455, price.getProductId());
        assertEquals(9.99, price.getPrice());
    }
}
