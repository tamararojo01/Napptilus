package com.demonapptilus.business;

import com.demonapptilus.business.dto.PriceDto;

import java.time.LocalDateTime;

public interface PriceService {

    PriceDto getPrice(Long brandId, Long productId, LocalDateTime date);
}
