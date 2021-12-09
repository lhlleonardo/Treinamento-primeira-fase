package com.primeirafase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.mercadolivre.com.br/");

            driver.findElement(By.id("cb1-edit")).sendKeys("kindle" + Keys.ENTER);

            WebElement resultQuantity = wait.until(presenceOfElementLocated(By.className("ui-search-search-result__quantity-results")));

            System.out.println("Foram encontrados " + resultQuantity.getAttribute("textContent") + "(s).");

            WebElement result = driver.findElement(By.cssSelector("div.ui-search"));

            List<WebElement> results = result.findElements(By.cssSelector("div.ui-search-result__content-wrapper"));

            for (WebElement r : results) {
                System.out.println(r.getText());
            }

        } finally {
            //driver.quit();
        }

    }
}
