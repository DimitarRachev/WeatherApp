package com.brainstartech.weathermodule.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;


import javax.transaction.Transactional;

import com.brainstartech.weathermodule.entity.WeatherEntry;
import com.brainstartech.weathermodule.entity.WeatherEntryDto;
import com.brainstartech.weathermodule.repository.WeatherEntryRepository;
import com.brainstartech.weathermodule.service.WeatherEntryService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WeatherEntryServiceImpl implements WeatherEntryService {
  private final WeatherEntryRepository weatherEntryRepository;
  private final ModelMapper mapper;
  @Transactional
  @Override public WeatherEntryDto updateWeather(String location, BigDecimal temperature) {
    WeatherEntry
      weatherEntry = weatherEntryRepository.findByLocation(location).orElse(new WeatherEntry(location, temperature));
    weatherEntry
      .setAverageTemp(weatherEntry.getAverageTemp()
        .multiply(BigDecimal.valueOf(weatherEntry.getCountMeasured()))
        .add(temperature)
        .divide(BigDecimal.valueOf(weatherEntry.getCountMeasured() + 1),2, RoundingMode.HALF_EVEN));
    weatherEntry.setCountMeasured(weatherEntry.getCountMeasured() + 1);
    weatherEntryRepository.save(weatherEntry);
    return mapper.map(weatherEntry, WeatherEntryDto.class);
  }
}
