package com.demonapptilus.api;


import com.demonapptilus.business.dto.PriceDto;
import com.demonapptilus.business.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/demo/brand/{brandId}/productId/{productId}/date/{date}")
public class PriceController {

    private PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/price")
    public PriceDto getPrice(@PathVariable Long brandId, @PathVariable Long productId,
                             @PathVariable
                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {

        PriceDto priceDto = priceService.getPrice(brandId, productId, date);
        return priceDto;
    }
}