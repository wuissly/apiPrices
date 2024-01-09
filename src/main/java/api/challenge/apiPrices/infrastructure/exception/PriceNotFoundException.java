package api.challenge.apiPrices.infrastructure.exception;

public class PriceNotFoundException extends RuntimeException {

    private final String code;
    private final String description;

    public PriceNotFoundException(String code, String description) {
        this.code=code;
        this.description=description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
