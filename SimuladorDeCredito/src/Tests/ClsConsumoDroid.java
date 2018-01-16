package Tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Global.ClsDriver;
import Models.ClsCreditoConsumoDroid;

public class ClsConsumoDroid extends ClsCreditoConsumoDroid{
     
     @BeforeMethod
     public void Before() throws MalformedURLException, InterruptedException {
          LoadApp("ClsConsumoDroid");
     }
     
     @Test
     public void ClConsumoDroid() throws InterruptedException, IOException {
          ClicMore();
          SelectOption("textviewInfo", "Simuladores");
          SelectOption("textviewInfo", "Crédito Personal");
          SelectionCmBox("spinnerDestino", "Crédito Personal");
          SelectionCmBox("spinnerSegmento", "Preferencial");
          AddContent("edittextMonto", "20000000");
          AddContent("edittextDuracion", "60");
          SelectionCmBox("spinnerTasa", "Tasa Fija (Mes Vencida)");
          ClickCalcular();
          ExtractValue();
     }
     
     @AfterMethod
     public void After(){
    	 ClsDriver.DriverDroid.quit();
     }
}

