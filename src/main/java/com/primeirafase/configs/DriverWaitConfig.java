package com.primeirafase.configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.Instant;

public class DriverWaitConfig {

    public WebDriverWait driverWait(WebDriver webDriver, Integer segundos) {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(segundos));

        return wait;
    }
}
