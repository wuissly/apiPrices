package api.challenge.apiPrices.infrastructure.exception;

public class InvalidDateException extends RuntimeException {

    private final String code;
    private final String description;

    public InvalidDateException(String code, String description) {
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
