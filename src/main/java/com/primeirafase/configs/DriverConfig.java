package com.primeirafase.configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverConfig {

    public WebDriver chromeDriver() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        
        return new ChromeDriver();
    }

    public WebDriver firefoxDriver() {

        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

        return new FirefoxDriver();
    }
}
