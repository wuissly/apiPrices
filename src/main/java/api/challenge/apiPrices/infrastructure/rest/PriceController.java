package api.challenge.apiPrices.infrastructure.rest;


import api.challenge.apiPrices.application.service.PriceService;


import api.challenge.apiPrices.domain.model.Price;
import api.challenge.apiPrices.infrastructure.exception.PriceNotFoundException;
import api.challenge.apiPrices.infrastructure.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value = "/api/challenge", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Price", description = "Product prices")
public class PriceController {
    private final PriceService priceService;
    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(path = "/{date}/{productId}/{brandId}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "get by date, Product_id and brandId")
    @Validated
    public ResponseEntity<Price> getPrice(
            @Parameter(description = "date, yyyy-MM-dd HH:mm:ss") @PathVariable("date")
            @NotBlank(message = Constants.BAD_REQUEST_DATE) String date,
            @Parameter(description = "productId") @PathVariable("productId")
            @NotBlank(message = Constants.BAD_REQUEST_PRODUCT_ID) Integer productId,
            @Parameter(description = "brandId") @PathVariable("brandId")
            @NotBlank(message = Constants.BAD_REQUEST_BRAND_ID) Long brandId
    ) throws PriceNotFoundException {

        log.info("request params -> [date:{}], [productId: {}], [brandid: {}]", date,productId,brandId);
        var response = priceService.getPrice(date,productId,brandId);
        log.info("response {}", response);

        return ResponseEntity.ok().body(response);
    }
}
