package com;

import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.cucumber.KarateStats;
import com.maha.ecommerce.Application;
import cucumber.api.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@CucumberOptions(tags = {"~@ignore", "@CDC"})
public class ContractsRunner {

  public static ConfigurableApplicationContext context;

  @BeforeAll
  static void before() {
    SpringApplication springApplication = new SpringApplication(Application.class);
    context = springApplication.run();
    log.info("Application has been started!");
  }

  @AfterAll
  static void after() {
    log.info("Stopping the application!");
    context.close();
  }

  @Test
  public void testParallel() {
    KarateStats stats = CucumberRunner.parallel(getClass(), 1);
    Assertions.assertEquals(0, stats.getFailCount(), "scenarios failed");
    Assertions.assertTrue(stats.getTestCount() > 0, "scenarios not found");
  }
}
