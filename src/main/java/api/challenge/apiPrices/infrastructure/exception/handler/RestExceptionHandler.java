package api.challenge.apiPrices.infrastructure.exception.handler;



import api.challenge.apiPrices.infrastructure.exception.ErrorDetail;
import api.challenge.apiPrices.infrastructure.exception.ErrorResponse;
import api.challenge.apiPrices.infrastructure.exception.InvalidDateException;
import api.challenge.apiPrices.infrastructure.exception.PriceNotFoundException;
import com.challenge.plataforma.infrastructure.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
@RequestMapping
@ResponseBody
@Slf4j
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PriceNotFoundException.class)
    public ErrorResponse priceNotFoundException(PriceNotFoundException ex) {
        log.error("PriceNotFoundException");
        var errorDetail = ErrorDetail.builder().code(ex.getCodigo()).mensaje(ex.getDescripcion()).build();
        return ErrorResponse.builder().code(HttpStatus.BAD_REQUEST.name()).message(Constants.INVALID_PARAMS)
                .errors(errorDetail).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidDateException.class)
    public ErrorResponse fechaInvalidaException(InvalidDateException ex) {
        log.error("FechaInvalidaException");
        var errorDetail = ErrorDetail.builder().code(ex.getCode()).mensaje(ex.getDescription()).build();
        return ErrorResponse.builder().code(HttpStatus.BAD_REQUEST.name()).message(Constants.INVALID_PARAMS)
                .errors(errorDetail).build();
    }
}
