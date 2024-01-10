package api.challenge.apiPrices.infrastructure.rest;


import api.challenge.apiPrices.application.ApiPricesApplication;

import api.challenge.apiPrices.infrastructure.utils.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest(classes = {ApiPricesApplication.class})
public class PriceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test_getPrice_case_1() throws Exception {

        mockMvc.perform(get("/api/challenge/2020-06-14 10:00:00/35455/1").contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(1));

    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test_getPrice_case_2() throws Exception {

        mockMvc.perform(get("/api/challenge/2020-06-14 16:00:00/35455/1").contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(2));

    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test_getPrice_case_3() throws Exception {

        mockMvc.perform(get("/api/challenge/2020-06-14 21:00:00/35455/1").contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(1));

    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    void test_getPrice_case_4() throws Exception {

        mockMvc.perform(get("/api/challenge/2020-06-15 10:00:00/35455/1").contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(3));

    }

    @Test
    @DisplayName(" Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    void test_getPrice_case_5() throws Exception {

        mockMvc.perform(get("/api/challenge/2020-06-16 21:00:00/35455/1").contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(4));
    }

    @Test
    @DisplayName(" Test 6: product not found ")
    void test_getPrice_case_not_found() throws Exception {

        mockMvc.perform(get("/api/challenge/2020-06-16 21:00:00/354555/1").contentType("application/json"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors.message").value(Constants.DESCRIPTION_NOT_FOUND));
    }


    @Test
    @DisplayName(" Test 7: invalid date exception ")
    void test_getPrice_case_invalid_date() throws Exception {

        mockMvc.perform(get("/api/challenge/2020-13-16/35455/2").contentType("application/json"))
                .andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors.message").value(Constants.DESCRIPTION_INVALID_DATE));
    }

}
