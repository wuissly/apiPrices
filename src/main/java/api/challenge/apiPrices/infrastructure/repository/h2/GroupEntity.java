package api.challenge.apiPrices.infrastructure.repository.h2;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "grupo")
public class GroupEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )
    @Column(name = "id")
    private Long id;

    private String description;

}