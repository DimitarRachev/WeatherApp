package com.brainstartech.weathermodule.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherEntryDto {
  private String location;

  private BigDecimal averageTemp;

  private Long countMeasured;
}
