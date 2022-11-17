package com.brainstartech.weathermodule.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WeatherEntry {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String location;

  @Column
  private BigDecimal averageTemp;

  @Column
  private Long countMeasured;

  public WeatherEntry(String location, BigDecimal temperature) {
    this.location = location;
    this.averageTemp = temperature;
    this.countMeasured = 0L;
  }
}
