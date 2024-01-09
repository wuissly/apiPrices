package api.challenge.apiPrices.infrastructure.adapters;

import java.sql.Timestamp;

import api.challenge.apiPrices.infrastructure.repository.h2.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public interface PriceRepositoryPersist extends JpaRepository<PriceEntity, Long> {

    @Query(value = "SELECT * FROM PRICES p WHERE p.BRAND_ID = ?1 AND p.PRODUCT_ID = ?2 AND  ?3 BETWEEN p.START_DATE AND p.END_DATE order by p.PRIORITY DESC LIMIT 1" ,nativeQuery = true)
    PriceEntity findFisrt(Long brandId, Integer productId, Timestamp date);

}

