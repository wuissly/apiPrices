package api.challenge.apiPrices.infrastructure.repository.h2;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prices")
public class PriceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )
    private Long id;

    @ManyToOne
    @JoinColumn(name="brand_id", nullable=false)
    private GroupEntity brandId;

    @NotNull
    @Column(name = "start_date")
    private Timestamp startDate;

    @NotNull
    @Column(name = "end_date")
    private Timestamp endDate;

    @NotNull
    @Column(name = "price_list")
    private Integer priceList;

    @Column(name = "product_id")
    private Integer productId;

    @NotNull
    @Column(name = "priority")
    private Integer priority;

    @NotNull
    @Column(name = "price")
    private Double price;

    @Column(name = "curr")
    private String curr;

}