package api.challenge.apiPrices.infrastructure.exception;

import api.challenge.apiPrices.infrastructure.utils.Constants;
import org.junit.Assert;
import org.junit.Test;

public class InvalidDateExceptionTest  {
    
    @Test
    public void testGetException_Invalid_Date() {
        String code = Constants.INVALID_DATE;
        String description = Constants.DESCRIPTION_INVALID_DATE;

        InvalidDateException exception = new InvalidDateException(code, description);

        Assert.assertEquals(code, exception.getCode());
        Assert.assertEquals(description, exception.getDescription());
    }


}
