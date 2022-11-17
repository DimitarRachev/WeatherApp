package com.brainstartech.weathermodule.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

  @Bean
  public ModelMapper modelmapper() {return new ModelMapper();
  }
}
