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
import lombok.extern.log4j.Log4j2;

@RestController()
@Log4j2
@RequiredArgsConstructor
public class WeatherEntryController {
  @Value("${server.instance.id}")
  private int instanceId;

  private final WeatherEntryService weatherEntryService;

  @PostMapping("/weather/{location}/{temperature}")
  public ResponseEntity<String> updateWeather(@PathVariable String location, @PathVariable BigDecimal temperature) {
    WeatherEntryDto response = weatherEntryService.updateWeather(location, temperature);
    log.info(
      String.format("Updated weather in instance: %d at: %s counter: %s", instanceId, response.getLocation(),
        response.getCountMeasured()));
    return ResponseEntity.ok(
      String.format("%s %s %s%n", response.getLocation(), response.getAverageTemp(), response.getCountMeasured()));
  }
}
