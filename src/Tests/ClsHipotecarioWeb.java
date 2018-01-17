package Tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Models.ClsCreditoHipotecarioWeb;

public class ClsHipotecarioWeb extends ClsCreditoHipotecarioWeb{
     
     @BeforeMethod
     public void Before() throws InterruptedException {
          LoadPage("ClsHipotecarioWeb");
     }
     
     @Test
     public void ClHipotecarioWeb() throws InterruptedException, IOException {
          Search("simulador");
          SelectLink("Simulador Solución Inmobiliaria");
          SelectionOption("combotipoFinanciacion", "Crédito Hipotecario");
          SelectionOption("comboDestinoCredito", "Apartamento");
          SelectionOption("comboOpcionSimular", "Dependiendo del monto que quiero prestar");
          SelectionOption("comboPlanAmortizacion", "Cuota fija-Tasa fija en pesos");
          SelectionOption("textPlazoAnios", "5");
          SelectionOption("dateFechaNacimiento", "1984-12-05");
          SelectionOption("comboDeptoColomnbia", "Antioquia");
          SelectionOption("textValorBien", "100000000");
          SelectionOption("textValorPrestamo", "20000000");
          BtnSimular();
          ExtractValue();
     }
}

