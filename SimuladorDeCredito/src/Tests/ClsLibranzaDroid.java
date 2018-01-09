package Tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import Models.ClsCreditoLibranzaDroid;

public class ClsLibranzaDroid extends ClsCreditoLibranzaDroid{
     
     @Before
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
}

