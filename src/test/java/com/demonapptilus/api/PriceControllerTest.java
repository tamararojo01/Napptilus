package com.demonapptilus.api;

import com.demonapptilus.business.PriceService;
import com.demonapptilus.business.dto.PriceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    public static final long BRAND_ID = 1L;
    public static final long PRODUCT_ID = 35455L;
    public static final double PRICE1 = 35.5D;
    public static final double PRICE2 = 25.45D;
    public static final double PRICE4 = 30.5D;
    public static final double PRICE5 = 38.95D;
    private PriceController priceController;

    @Mock
    private PriceService priceService;


    @BeforeEach
    void setUp() {
        priceController = new PriceController(priceService);

    }

    @Test
    void getPrice1() {

        LocalDateTime date = LocalDateTime.of(2020, Month.JULY, 14, 10, 00, 00);
        PriceDto priceDtoExpected = PriceDto.builder().price(PRICE1).build();

        when(priceService.getPrice(BRAND_ID, PRODUCT_ID, date)).thenReturn(priceDtoExpected);

        PriceDto priceDto = priceController.getPrice(BRAND_ID ,PRODUCT_ID, date);
        assertEquals(priceDto.getPrice(), priceDtoExpected.getPrice());
    }
    @Test
    void getPrice2() {

        LocalDateTime date = LocalDateTime.of(2020, Month.JULY, 14, 16, 00, 00);
        PriceDto priceDtoExpected = PriceDto.builder().price(PRICE2).build();

        when(priceService.getPrice(BRAND_ID, PRODUCT_ID, date)).thenReturn(priceDtoExpected);

        PriceDto priceDto = priceController.getPrice(BRAND_ID ,PRODUCT_ID, date);
        assertEquals(priceDto.getPrice(), priceDtoExpected.getPrice());
    }

    @Test
    void getPrice3() {

        LocalDateTime date = LocalDateTime.of(2020, Month.JULY, 14, 21, 00, 00);
        PriceDto priceDtoExpected = PriceDto.builder().price(PRICE1).build();

        when(priceService.getPrice(BRAND_ID, PRODUCT_ID, date)).thenReturn(priceDtoExpected);

        PriceDto priceDto = priceController.getPrice(BRAND_ID ,PRODUCT_ID, date);
        assertEquals(priceDto.getPrice(), priceDtoExpected.getPrice());
    }

    @Test
    void getPrice4() {

        LocalDateTime date = LocalDateTime.of(2020, Month.JULY, 15, 10, 00, 00);
        PriceDto priceDtoExpected = PriceDto.builder().price(PRICE4).build();

        when(priceService.getPrice(BRAND_ID, PRODUCT_ID, date)).thenReturn(priceDtoExpected);

        PriceDto priceDto = priceController.getPrice(BRAND_ID ,PRODUCT_ID, date);
        assertEquals(priceDto.getPrice(), priceDtoExpected.getPrice());
    }

    @Test
    void getPrice5() {

        LocalDateTime date = LocalDateTime.of(2020, Month.JULY, 16, 21, 00, 00);
        PriceDto priceDtoExpected = PriceDto.builder().price(PRICE5).build();

        when(priceService.getPrice(BRAND_ID, PRODUCT_ID, date)).thenReturn(priceDtoExpected);

        PriceDto priceDto = priceController.getPrice(BRAND_ID ,PRODUCT_ID, date);
        assertEquals(priceDto.getPrice(), priceDtoExpected.getPrice());
    }
}