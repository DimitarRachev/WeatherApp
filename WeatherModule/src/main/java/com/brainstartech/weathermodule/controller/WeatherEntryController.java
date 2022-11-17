package com.brainstartech.weathermodule.controller;

import java.math.BigDecimal;


import com.brainstartech.weathermodule.entity.WeatherEntryDto;
import com.brainstartech.weathermodule.service.WeatherEntryService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController()
@RequiredArgsConstructor
public class WeatherEntryController {
  private final WeatherEntryService weatherEntryService;

  @PostMapping("/weather/{location}/{temperature}")
  public ResponseEntity<String> updateWeather(@PathVariable String location, @PathVariable BigDecimal temperature) {
    WeatherEntryDto response = null;
    while(response == null) {
      try {
        response = weatherEntryService.updateWeather(location, temperature);
      } catch (Exception e) { }
    }
    return ResponseEntity.ok(response.getCountMeasured() + System.lineSeparator());
  }
}
