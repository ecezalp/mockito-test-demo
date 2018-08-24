package com.mockitodemo.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Milk {
  public String type;
  public Integer id;
  public Double fatPercentage;
}
