package Tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Global.ClsDriver;
import Models.ClsCreditoLibranzaDroid;

public class ClsLibranzaDroid extends ClsCreditoLibranzaDroid{
     
     @BeforeMethod
     public void Before() throws MalformedURLException, InterruptedException {
          LoadApp("ClsLibranzaDroid");
     }
     
     @Test
     public void ClLibranzaDroid() throws InterruptedException, IOException {
          ClicMore();
          SelectOption("textviewInfo", "Simuladores");
          SelectOption("textviewInfo", "Libranza");
          SelectionCmBox("spinnerDestino", "Libranza");
          SelectionCmBox("spinnerSegmento", "Preferencial");
          AddContent("edittextMonto", "20000000");
          AddContent("edittextDuracion", "60");
          SelectionCmBox("spinnerTasa", "Tasa Variable (Ptos adicionales a la DTF TA)");
          ClickCalcular();
          ExtractValue();
     }
     
     @AfterMethod
     public void After(){
    	ClsDriver.DriverDroid.quit();
     }
}

