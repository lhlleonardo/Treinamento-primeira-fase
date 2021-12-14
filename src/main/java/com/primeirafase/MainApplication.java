package com.primeirafase;

import com.primeirafase.configs.DriverConfig;
import com.primeirafase.model.Demanda;
import com.primeirafase.service.BuscaProduto;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) {

        WebDriver driverConfig = new DriverConfig().chromeDriver();

        BuscaProduto buscaProduto = new BuscaProduto();

        WebDriverWait wait = new WebDriverWait(driverConfig, Duration.ofSeconds(10));

        try {
            driverConfig.get("https://www.mercadolivre.com.br/");

            driverConfig.findElement(By.id("cb1-edit")).sendKeys(buscaProduto.buscarItem() + Keys.ENTER);

            WebElement quantidadadeResultados = wait.until(presenceOfElementLocated(By.className("ui-search-search-result__quantity-results")));

            System.out.println("Foram encontrados " + quantidadadeResultados.getAttribute("textContent") + "(s).");

            List<WebElement> resultsWait = wait.until(presenceOfAllElementsLocatedBy(By.xpath("//div[@class='ui-search-result__wrapper']")));

            for (WebElement resultadoParcial : resultsWait) {

                System.out.println(resultadoParcial.getAttribute("textContent"));

                WebElement precoProduto = resultadoParcial.findElement(By.xpath("//div[@class='ui-search-price ui-search-price--size-medium ui-search-item__group__element']//div[@class='ui-search-price__second-line']//span[@class='price-tag-amount']"));

                System.out.println(precoProduto.getAttribute("textContent"));
            }

            //WebElement result = driverConfig.findElement(By.xpath("//div[@class='ui-search-result__wrapper']"));

//            List<WebElement> resultsValue = resultsWait.findElements(By.xpath("//div[@class='ui-search-price ui-search-price--size-medium ui-search-item__group__element']//div[@class='ui-search-price__second-line']//span[@class='price-tag-amount']"));
//
//            for (WebElement r : resultsValue) {
//                System.out.println(r.getAttribute("textContent"));
//            }
//
//            List<WebElement> resultsDesc = resultsWait.findElements(By.xpath("//div[@class='ui-search-result__content-wrapper']//h2[@class='ui-search-item__title ui-search-item__group__element']"));
//
//            for (WebElement r : resultsDesc) {
//                System.out.println(r.getText());
//            }
//
//            List<WebElement> resultsImg = resultsWait.findElements(By.xpath("//img[@class='ui-search-result-image__element']"));
//
//            for (WebElement r : resultsImg) {
//                System.out.println(r.getAttribute("currentSrc"));
//            }

        } finally {
            //driverConfig.quit();
        }

    }
}
