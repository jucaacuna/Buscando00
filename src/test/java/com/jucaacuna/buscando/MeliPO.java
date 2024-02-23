package com.jucaacuna.buscando;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
 * Pagina base para el sitio MercadoLibre.
 * 
 * @author: jucaacuna
 */
public class MeliPO extends PaginaBase {

  public MeliPO(String browser) {
    super(browser);
    visitar("https://www.mercadolibre.com.uy/");

  }

  public void buscarProducto(String p, String p2) {
    WebElement cuadrobusqueda = encontrar(By.id("cb1-edit"));
    cuadrobusqueda.sendKeys(p);
    WebElement boton = encontrar(By.className("nav-search-btn"));
    this.click(boton);

    List<WebElement> productos = driver.findElements(By.className("ui-search-result__wrapper"));
    for (WebElement pr : productos) {
      if (pr.getText().contains(p2)) {
        System.out.println(" ### ### ### ");
        System.out.println(pr.getText());
      }
    }
  }
}
