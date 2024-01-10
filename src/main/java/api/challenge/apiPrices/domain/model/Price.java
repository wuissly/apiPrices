package api.challenge.apiPrices.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Price {


    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Integer productId;
    private Double price;

}
