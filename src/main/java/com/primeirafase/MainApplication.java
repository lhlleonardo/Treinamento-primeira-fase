package com.primeirafase;

import com.primeirafase.configs.DriverConfig;
import com.primeirafase.configs.DriverWaitConfig;
import com.primeirafase.model.Demanda;
import com.primeirafase.model.Produto;
import com.primeirafase.service.BuscaProduto;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MainApplication {

    public static void main(String[] args) {

        WebDriver driverConfig = new DriverConfig().chromeDriver();

        WebDriverWait wait = new DriverWaitConfig().driverWait(driverConfig, 10);

        BuscaProduto buscaProduto = new BuscaProduto();

        try {
            Demanda demanda = buscaProduto.buscarProdutos(wait, driverConfig);
            System.out.println(demanda.retornarBusca());
        } finally {
            driverConfig.quit();
        }
    }
}
