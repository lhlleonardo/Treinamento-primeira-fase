package com.primeirafase;

import com.primeirafase.configs.DriverConfig;
import com.primeirafase.configs.DriverWaitConfig;
import com.primeirafase.service.BuscaProduto;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MainApplication {

    public static void main(String[] args) {

        WebDriver driverConfig = new DriverConfig().chromeDriver();

        BuscaProduto buscaProduto = new BuscaProduto();

        WebDriverWait wait = new DriverWaitConfig().driverWait(driverConfig, 10);

        try {
            driverConfig.get("https://www.mercadolivre.com.br/");

            wait.until(presenceOfElementLocated(By.id("cb1-edit"))).sendKeys(buscaProduto.buscarItem("Kindle") + Keys.ENTER);

            WebElement quantidadadeResultados = wait.until(presenceOfElementLocated(By.className("ui-search-search-result__quantity-results")));

            System.out.println("Foram encontrados " + quantidadadeResultados.getAttribute("textContent") + "(s).");

            List<WebElement> resultsWait = wait.until(presenceOfAllElementsLocatedBy(By.xpath("//div[@class='ui-search-result__wrapper']")));

            for (WebElement resultado : resultsWait) {

                //driverConfig.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

                //WebElement precoProduto = resultado.findElement(By.xpath(".//div[@class='ui-search-price ui-search-price--size-medium ui-search-item__group__element']//div[@class='ui-search-price__second-line']//span[@class='price-tag-amount']"));

                //WebElement descricaoProduto = resultado.findElement(By.xpath(".//div[@class='ui-search-result__content-wrapper']//h2[@class='ui-search-item__title ui-search-item__group__element']"))

                //wait.until(visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ui-search-result__image']//img[@class='ui-search-result-image__element']")));

                //resultado.sendKeys(Keys.PAGE_DOWN);

                //WebElement imagemProduto = wait.until(presenceOfElementLocated(By.xpath(".//div[@class='ui-search-result__image']//img[@class='ui-search-result-image__element']")));

                //WebElement imagemProduto = wait.until(presenceOfElementLocated(By.xpath(String.valueOf(resultado.findElement(By.xpath(".//div[@class='ui-search-result__image']//img[@class='ui-search-result-image__element']"))))));

                WebElement imagemProduto = resultado.findElement(By.xpath(".//img[@class='ui-search-result-image__element']"));
                System.out.println(imagemProduto.getAttribute("src"));

                //Thread.sleep(1000);
            }
        } finally {
            driverConfig.quit();
        }

    }
}
