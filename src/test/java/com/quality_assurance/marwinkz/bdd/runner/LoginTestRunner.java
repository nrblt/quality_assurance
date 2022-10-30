package com.quality_assurance.marwinkz.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:com.quality_assurance.marwinkz.bdd.features", glue = "steps")
public class LoginTestRunner {

}
