package com.brainstartech.weathermodule.service;

import java.math.BigDecimal;

import com.brainstartech.weathermodule.entity.WeatherEntryDto;


public interface WeatherEntryService {
  WeatherEntryDto updateWeather(String location, BigDecimal temperature);


}
