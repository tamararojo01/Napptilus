package com.demonapptilus.business.impl;

import com.demonapptilus.business.PriceService;
import com.demonapptilus.entity.Price;
import com.demonapptilus.infrastructure.PriceRepository;
import com.demonapptilus.business.dto.PriceDto;
import com.demonapptilus.business.mapper.PriceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
@Slf4j
@Service
public class PriceServiceImpl implements PriceService {

    private PriceRepository priceRepository;
    private PriceMapper priceMapper;

    public PriceServiceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    public PriceDto getPrice(Long brandId, Long productId, LocalDateTime date) {

        List<Price> prices = priceRepository.findByBrandProductAndDate(brandId, productId, date);
        if (!prices.isEmpty()) {
            Price price = prices.stream().max(Comparator.comparing(p -> p.getPriority())).get();
            return priceMapper.fromDomain(price);
        }
        return null;
    }
}
