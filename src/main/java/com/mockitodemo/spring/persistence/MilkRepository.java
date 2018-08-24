package com.mockitodemo.spring.persistence;

import com.mockitodemo.spring.domain.Milk;
import org.springframework.stereotype.Repository;

@Repository
public class MilkRepository {

  public Milk find(String milkType) {
    return Milk.builder()
      .type(milkType)
      .fatPercentage(5D)
      .id(1)
      .build();
  }
}
