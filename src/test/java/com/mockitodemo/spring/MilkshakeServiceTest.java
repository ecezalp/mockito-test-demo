package com.mockitodemo.spring;

import com.mockitodemo.spring.config.AppConfig;
import com.mockitodemo.spring.domain.Chocolate;
import com.mockitodemo.spring.domain.Ice;
import com.mockitodemo.spring.domain.Milk;
import com.mockitodemo.spring.domain.Milkshake;
import com.mockitodemo.spring.domain.service.CounterService;
import com.mockitodemo.spring.domain.service.MilkshakeService;
import com.mockitodemo.spring.persistence.ChocolateRepository;
import com.mockitodemo.spring.persistence.MilkRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class MilkshakeServiceTest {

  @Mock
  private MilkRepository milkRepository;

  @Mock
  private ChocolateRepository chocolateRepository;

  @Mock
  private CounterService counterService;

  private MilkshakeService milkshakeService;

  @Before
  public void setup() {
    milkshakeService = new MilkshakeService(milkRepository, chocolateRepository, counterService);
  }

  @Test
  public void makeChocolateMilkshake_makesAShake() {
    Milk expectedMilk = Milk.builder().fatPercentage(5D).id(1).type("whole").build();
    Chocolate expectedChocolate = Chocolate.builder().cacaoPercentage(70D).fatPercentage(12D).id(2).type("dark").build();
    Ice expectedIce = Ice.builder().amount(3).build();

    when(milkRepository.find("whole")).thenReturn(expectedMilk);
    when(chocolateRepository.find("dark")).thenReturn(expectedChocolate);

    Milkshake expectedMilkshake = Milkshake.builder()
      .chocolate(expectedChocolate)
      .milk(expectedMilk)
      .ice(expectedIce)
      .build();

    Milkshake actualMilkshake = milkshakeService.makeChocolateMilkshake("whole", "dark", 3);

    assertThat(actualMilkshake).isEqualTo(expectedMilkshake);
  }

  @Test
  public void makeChocolateMilkshake_cleansTheCounter() {
    when(milkRepository.find("whole")).thenReturn(Milk.builder().build());
    when(chocolateRepository.find("dark")).thenReturn(Chocolate.builder().build());

    milkshakeService.makeChocolateMilkshake("whole", "dark", 3);

    verify(counterService, times(1)).clean();
  }
}
