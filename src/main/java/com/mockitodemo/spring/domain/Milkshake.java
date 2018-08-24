package com.mockitodemo.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Milkshake {
  private Milk milk;
  private Ice ice;
  private Chocolate chocolate;
}
