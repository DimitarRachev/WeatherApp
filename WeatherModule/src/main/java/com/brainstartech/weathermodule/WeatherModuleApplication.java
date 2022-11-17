package com.brainstartech.weathermodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WeatherModuleApplication {

  public static void main(String[] args) {
    SpringApplication.run(WeatherModuleApplication.class, args);
  }

}
