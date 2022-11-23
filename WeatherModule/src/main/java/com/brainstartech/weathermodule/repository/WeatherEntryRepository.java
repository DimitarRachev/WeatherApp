package com.brainstartech.weathermodule.repository;

import java.util.Optional;


import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import com.brainstartech.weathermodule.entity.WeatherEntry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherEntryRepository extends JpaRepository<WeatherEntry, Long> {

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  Optional<WeatherEntry> findByLocation(String location);
}
