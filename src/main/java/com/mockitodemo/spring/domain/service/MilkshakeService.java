package com.mockitodemo.spring.domain.service;

import com.mockitodemo.spring.domain.Chocolate;
import com.mockitodemo.spring.domain.Ice;
import com.mockitodemo.spring.domain.Milk;
import com.mockitodemo.spring.domain.Milkshake;
import org.springframework.beans.factory.annotation.Autowired;
import com.mockitodemo.spring.persistence.ChocolateRepository;
import com.mockitodemo.spring.persistence.MilkRepository;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.Counter;

@Service
public class MilkshakeService {

  private MilkRepository milkRepository;
  private ChocolateRepository chocolateRepository;
  private CounterService counterService;

  @Autowired
  public MilkshakeService(MilkRepository milkRepository, ChocolateRepository chocolateRepository, CounterService counterService) {
    this.milkRepository = milkRepository;
    this.chocolateRepository = chocolateRepository;
    this.counterService = counterService;
  }

  public Milkshake makeChocolateMilkshake(String milkType, String chocolateType, Integer iceAmount) {
    Milk milk = milkRepository.find(milkType);
    Chocolate chocolate = chocolateRepository.find(chocolateType);
    Ice ice = Ice.builder().amount(iceAmount).build();

    Milkshake milkshake = shake(milk, chocolate, ice);

    cleanTheCounter();

    return milkshake;
  }

  private Milkshake shake(Milk milk, Chocolate chocolate, Ice ice) {
    return Milkshake
      .builder()
      .milk(milk)
      .chocolate(chocolate)
      .ice(ice)
      .build();
  }

  private void cleanTheCounter() {
    counterService.clean();
  }
}
