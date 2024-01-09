package api.challenge.apiPrices.infrastructure.adapters;


import api.challenge.apiPrices.domain.ports.PriceRepository;
import api.challenge.apiPrices.infrastructure.repository.h2.PriceEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PriceRepositoryH2 implements PriceRepository {


    private final PriceRepositoryPersist priceRepositoryPersist;

    public PriceRepositoryH2(PriceRepositoryPersist priceRepositoryPersist) {
        this.priceRepositoryPersist = priceRepositoryPersist;
    }

    @Override
    public List<PriceEntity> getPrice(Long brandId, Integer productId, LocalDateTime date) {
        return priceRepositoryPersist.findAll(brandId,productId,date);
    }
    
    
}
