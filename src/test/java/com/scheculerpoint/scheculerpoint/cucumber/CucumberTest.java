package com.scheculerpoint.scheculerpoint.cucumber;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberReportRunner.class)
@CucumberOptions(features = "src/test/resources",
                 plugin = {"pretty", "json:target/cucumber.json"})
public class CucumberTest {

}
