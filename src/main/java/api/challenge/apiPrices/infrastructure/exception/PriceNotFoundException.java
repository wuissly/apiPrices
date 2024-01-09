package api.challenge.apiPrices.infrastructure.exception;

public class PriceNotFoundException extends RuntimeException {

    private final String codigo;
    private final String descripcion;

    public PriceNotFoundException(String codigo, String descripcion) {
        this.codigo=codigo;
        this.descripcion=descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
