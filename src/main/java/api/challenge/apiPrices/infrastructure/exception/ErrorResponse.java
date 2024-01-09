package api.challenge.apiPrices.infrastructure.exception;

import lombok.*;

@Builder
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse  {

    private String code;
    private String message;
    private ErrorDetail errors;
}