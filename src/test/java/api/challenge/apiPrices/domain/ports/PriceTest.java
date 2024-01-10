package api.challenge.apiPrices.domain.ports;
import api.challenge.apiPrices.domain.model.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class PriceTest {
    
    @Test
    public void testSetAndGetProductId() {
        Integer productId = 35455;
        Price price = Price.builder().productId(productId).build();

        Assertions.assertEquals(productId, price.getProductId());
    }

    @Test
    public void testSetAndGetBrandId() {
        Long brandId = 1L;
        Price price = Price.builder().brandId(brandId).build();
        Assertions.assertEquals(brandId, price.getBrandId());
    }

    @Test
    public void testSetAndGetPriceList() {
        Integer priceList = 2;
        Price price = Price.builder().priceList(priceList).build();
        Assertions.assertEquals(priceList, price.getPriceList());
    }

    @Test
    public void testSetAndGetStartDate() {
        LocalDateTime startDate = LocalDateTime.now();
        Price price = Price.builder().startDate(startDate).build();
        Assertions.assertEquals(startDate, price.getStartDate());
    }

    @Test
    public void testSetAndGetEndDate() {
        LocalDateTime endDate = LocalDateTime.now().plusDays(2);
        Price price = Price.builder().endDate(endDate).build();
        Assertions.assertEquals(endDate, price.getEndDate());
    }

    @Test
    public void testSetAndGetPrice() {
        Double price = 9.99;
        Price priceTest = Price.builder().price(price).build();
        Assertions.assertEquals(price, priceTest.getPrice());
    }

}
