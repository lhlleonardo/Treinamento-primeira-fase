package com.primeirafase.service;

import com.primeirafase.model.Demanda;
import com.primeirafase.model.Produto;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Long.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BuscaProduto {

    public String buscarItem(String palavra){

        return palavra;
    }

    public Demanda buscarProdutos(WebDriverWait wait, WebDriver driverConfig) {

        driverConfig.get("https://www.mercadolivre.com.br/");

        wait.until(presenceOfElementLocated(By.id("cb1-edit"))).sendKeys(this.buscarItem("Kindle") + Keys.ENTER);

        String palavraBuscada = wait.until(presenceOfElementLocated(By.xpath("//h1[@class='ui-search-breadcrumb__title']"))).getAttribute("textContent");

        String quantidadadeResultados = wait.until(presenceOfElementLocated(By.className("ui-search-search-result__quantity-results"))).getAttribute("textContent");

        String totalPaginas = wait.until(presenceOfElementLocated(By.xpath("//li[@class='andes-pagination__page-count']"))).getAttribute("textContent");

        totalPaginas = totalPaginas.replaceAll("\\D+","");

        Demanda demanda = new Demanda();
        demanda.setBusca(palavraBuscada);
        demanda.setQtdeItens(quantidadadeResultados);

        for (int i = 1; i <= Integer.parseInt(totalPaginas) ; i++) {

            try {
                Thread.sleep(3000);
            }catch (InterruptedException e) {}

            List<WebElement> resultsWait = wait.until(presenceOfAllElementsLocatedBy(By.xpath("//div[@class='ui-search-result__wrapper']")));

            for (WebElement resultado : resultsWait) {

                JavascriptExecutor js = (JavascriptExecutor) driverConfig;

                String precoProduto = resultado.findElement(By.xpath(".//div[@class='ui-search-price ui-search-price--size-medium ui-search-item__group__element']//div[@class='ui-search-price__second-line']//span[@class='price-tag-amount']")).getAttribute("textContent");

                String descricaoProduto = resultado.findElement(By.xpath(".//div[@class='ui-search-result__content-wrapper']//h2[@class='ui-search-item__title ui-search-item__group__element']")).getAttribute("textContent");

                String imagemProduto = resultado.findElement(By.xpath(".//img[@class='ui-search-result-image__element']")).getAttribute("src");

                WebElement imagemProdutoCarregar = resultado.findElement(By.xpath(".//img[@class='ui-search-result-image__element']"));

                js.executeScript("arguments[0].scrollIntoView();", imagemProdutoCarregar);

                demanda.adicionaProduto(new Produto(precoProduto, descricaoProduto, imagemProduto));
            }

            if (wait.until(presenceOfElementLocated(By.xpath("//a[@class='andes-pagination__link ui-search-link'][@title='Seguinte']"))).isDisplayed()) {
                wait.until(presenceOfElementLocated(By.xpath("//a[@class='andes-pagination__link ui-search-link'][@title='Seguinte']"))).click();
            } else {
                continue;
            }

        }

        return demanda;
    }
}
