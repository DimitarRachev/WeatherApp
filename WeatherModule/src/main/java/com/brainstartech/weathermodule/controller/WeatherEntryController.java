package com.brainstartech.weathermodule.controller;

import java.math.BigDecimal;


import com.brainstartech.weathermodule.entity.WeatherEntryDto;
import com.brainstartech.weathermodule.service.WeatherEntryService;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController()
@RequiredArgsConstructor
public class WeatherEntryController {
  @Value("${update_weather.max_retry_attempts}")
  private int updateWeatherMaxRetryAttempts;

  private final WeatherEntryService weatherEntryService;

  @PostMapping("/weather/{location}/{temperature}")
  public ResponseEntity<String> updateWeather(@PathVariable String location, @PathVariable BigDecimal temperature) {
    WeatherEntryDto response = null;
    int retries = 0;
        while(response == null) {                                           //Retry until successful record in the database
//    while (response == null && retries < updateWeatherMaxRetryAttempts) {     //Retry with max attempts counter
      try {
        response = weatherEntryService.updateWeather(location, temperature);
      } catch (Exception e) {
        retries++;
      }
    }
    return ResponseEntity.ok(String.format("%s %s %s%n", response.getLocation(), response.getAverageTemp(),response.getCountMeasured()));
  }
}
