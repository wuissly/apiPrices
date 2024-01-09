package api.challenge.apiPrices.infrastructure.adapters;


import api.challenge.apiPrices.domain.ports.PriceRepository;
import api.challenge.apiPrices.infrastructure.repository.h2.PriceEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Component
public class PriceRepositoryH2 implements PriceRepository {


    private final PriceRepositoryPersist priceRepositoryPersist;

    public PriceRepositoryH2(PriceRepositoryPersist priceRepositoryPersist) {
        this.priceRepositoryPersist = priceRepositoryPersist;
    }

    @Override
    public PriceEntity getPrice(Long brandId, Integer productId, Timestamp date) {
        return priceRepositoryPersist.findFisrt(brandId,productId,date);
    }
    
    
}
