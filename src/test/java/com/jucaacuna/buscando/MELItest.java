package com.jucaacuna.buscando;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MELItest {

  MeliPO p;

  @Before
  public void setup() {
    p = new MeliPO("chrome");
  }

  @After
  public void cerrandotodo() {
    p.quit();
  }

  @Test
  public void dondeEstoy() {
    System.out.println("# Estamos en la página:" + p.driver.getTitle() + " #");
  }

  @Test
  public void a() {
    p.buscarProducto("Laptop", "Lenovo");
  }

}
