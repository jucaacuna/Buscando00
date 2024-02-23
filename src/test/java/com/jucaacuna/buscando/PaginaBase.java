package com.jucaacuna.buscando;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
 * Pagina base siguiendo el Page Object Model.
 * 
 * @author: jucaacuna
 * 
 */
public class PaginaBase {


  WebDriver driver;
  int timeoutSec = 10; // wait timeout (10 segundos por defecto)


  /*
   * Constructor.
   */
  public PaginaBase(String browser) {
    tipoBrowser(browser);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutSec));
  }

  /*
   * Determina como inicializar el driver según el parámetro.
   */
  private void tipoBrowser(String b) {
    if (b.matches("[Ff]irefox")) {
      driver = new FirefoxDriver();
    } else if (b.matches("[Cc]hrome")) {
      driver = new ChromeDriver();
    }
  }

  /*
   * Asigna valor al atributo timeoutSec.
   */
  public void setTimeoutSec(int timeoutSec) {
    this.timeoutSec = timeoutSec;
  }

  /*
   * Cierra la instancia del driver miembro de esta clase.
   */
  public void quit() {
    if (driver != null) {
      driver.quit();
    }
  }

  /*
   * Metodo para establecer la url de la pagina a cargar en el webdriver.
   */
  public void visitar(String url) {
    driver.get(url);
  }

  /*
   * Encuentra un elemento dentro del driver miembro de esta clase.
   */
  public WebElement encontrar(By element) {
    return driver.findElement(element);
  }

  /*
   * Click en un elemento.
   */
  public void click(WebElement element) {
    element.click();
  }

}
