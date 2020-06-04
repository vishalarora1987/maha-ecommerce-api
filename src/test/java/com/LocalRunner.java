package com;

import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.cucumber.KarateStats;
import cucumber.api.CucumberOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@CucumberOptions(tags = {"~@ignore", "@CDC"})
public class LocalRunner {
  @Test
  public void testParallel() {
    KarateStats stats = CucumberRunner.parallel(getClass(), 1);
    Assertions.assertEquals(0, stats.getFailCount(), "scenarios failed");
    Assertions.assertTrue(stats.getTestCount() > 0, "scenarios not found");
  }
}
