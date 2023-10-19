package com.demonapptilus.business.mapper;

import com.demonapptilus.entity.Price;
import com.demonapptilus.business.dto.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    @Mapping(source = "brand.id", target = "brandId")
    PriceDto fromDomain(Price price);
}