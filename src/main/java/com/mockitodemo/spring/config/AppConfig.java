package com.mockitodemo.spring.config;

import com.mockitodemo.spring.persistence.ChocolateRepository;
import com.mockitodemo.spring.persistence.MilkRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public MilkRepository milkRepository() {
    return new MilkRepository();
  }

  @Bean
  public ChocolateRepository chocolateRepository() {
    return new ChocolateRepository();
  }
}
