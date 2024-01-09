package api.challenge.apiPrices.domain.model;

import api.challenge.apiPrices.infrastructure.repository.h2.GroupEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;


@Data
@Builder
public class Price {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )
    private Long id;
    private Long brandId;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer priceList;
    private Integer productId;
    private Integer priority;
    private Double price;
    private String curr;
}
