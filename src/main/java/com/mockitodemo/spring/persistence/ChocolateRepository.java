package com.mockitodemo.spring.persistence;

import com.mockitodemo.spring.domain.Chocolate;
import org.springframework.stereotype.Repository;

@Repository
public class ChocolateRepository {

  public Chocolate find(String chocolateType){
    return Chocolate.builder()
      .type(chocolateType)
      .cacaoPercentage(70D)
      .fatPercentage(10D)
      .id(2)
      .build();
  }
}
