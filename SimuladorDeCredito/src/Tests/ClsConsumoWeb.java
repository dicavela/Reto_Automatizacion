package Tests;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import Models.*;

public class ClsConsumoWeb extends ClsCreditoConsumoWeb{
     
     @Before
     public void Before() throws InterruptedException {
          LoadPage("ClsConsumoWeb");
     }
     
     @Test
     public void ClConsumoWeb() throws InterruptedException, IOException {
          Search("simulador");
          SelectLink("Simulador Cr�dito de Consumo");
          SelectionOption("comboTipoSimulacion", "Simula tu Cuota");
          SelectionOption("dateFechaNacimiento", "1982-05-26");
          SelectionOption("comboTipoTasa", "Tasa Fija");
          SelectionOption("comboTipoProducto", "Cr�dito de Libre Inversi�n");
          ChkSafeEmployee();
          SelectionOption("textPlazoInversion", "60");
          SelectionOption("textValorPrestamo", "20000000");
          BtnSimular();
          ExtractValue();
     }
}

