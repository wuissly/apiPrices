package api.challenge.apiPrices.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;


@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )
    private Long id;
    private Long brandId;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer priceList;
    private Integer productId;
    private Double price;
    private String curr;


}
