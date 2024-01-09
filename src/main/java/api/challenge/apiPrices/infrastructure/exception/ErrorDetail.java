package api.challenge.apiPrices.infrastructure.exception;

import lombok.*;

@Builder
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {

    private String code;
    private String message;
}
