package com.jucaacuna.buscando;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.Duration;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BusquedaTest {

  WebDriver driver;

  @Before
  public void setup() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();

  }

  @After
  public void cerrandotodo() {
    driver.quit();
  }

  @Test
  public void buscando0utu() {
    int incidencias = 0;
    String url = "https://www.utu.edu.uy/convocatorias-elecci%C3%B3n-de-cargos";
    driver.get(url);
    List <WebElement> cards = driver.findElements(By.cssSelector("div.col-12.pt-3"));

    for (WebElement c: cards) {
      if (c.getText().contains("elección") &&  c.getText().contains("/2024")) {
        incidencias++;
        System.out.println(c.getText());
      }
    }

    assertTrue(incidencias>0);
  }
  @Test
  public void buscando2utu() {
    int incidencias = 0;
    String url = "http://www.utu.edu.uy/funcionarios";
    driver.get(url);
    List <WebElement> cards = driver.findElements(By.cssSelector("div.card.card-noticias.flex-md-row.mb-md-4.mr-3.mr-md-0"));

    for (WebElement c: cards) {
      if (c.getText().contains("Elección")) {
        incidencias++;
        System.out.println(c.getText());
      }
    }

    assertTrue(incidencias>0);
  }
}
