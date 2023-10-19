package com.demonapptilus.api;

import com.demonapptilus.DemoNapptilusApplication;
import com.demonapptilus.business.dto.PriceDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoNapptilusApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class PriceControllerIT {

    public static final long BRAND_ID = 1L;
    public static final long PRODUCT_ID = 35455L;

    public static final double PRICE1 = 38.95D;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getPriceByBrandProductDate() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, Month.JULY, 14, 16, 00, 00);

        MockHttpServletRequestBuilder request = createMockMvcGetActivePolicy(BRAND_ID, PRODUCT_ID, date);

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
        String responseBody = mvcResult.getResponse().getContentAsString();

        PriceDto priceDto = objectMapper.readValue(responseBody, PriceDto.class);
        assertEquals(PRICE1, priceDto.getPrice());

    }

    private MockHttpServletRequestBuilder createMockMvcGetActivePolicy(Long brandId, Long productId, LocalDateTime date) {
        return MockMvcRequestBuilders.get("/demo/brand/{brandId}/productId/{productId}/date/{date}/price", brandId, productId, date)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
    }
}
