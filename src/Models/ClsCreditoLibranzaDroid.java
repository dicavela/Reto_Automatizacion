package Models;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;

import Global.ClsBuilderExcel;
import Global.ClsDriver;
import io.appium.java_client.MobileElement;

public class ClsCreditoLibranzaDroid extends ClsDriver{
     
     public void LoadApp(String NameCP) throws MalformedURLException, InterruptedException {
          SetearDriverDroid();
          CreateEvidences(NameCP);
     }
     
     public void ClicMore() throws InterruptedException, IOException {
          DriverDroid.findElement(By.id("imbMas")).click();
          labelDroid("Clic en Mas");
     }
     
     public void SelectOption(String Element, String Value) throws InterruptedException, IOException {
          Thread.sleep(3000);
          List<MobileElement> lista = DriverDroid.findElementsById(Element);
          for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getText().equals(Value)) {
                     lista.get(i).click();
                     break;
                }
          }
          labelDroid("Clic en la Opcion " + Value);
     }

     public void SelectionCmBox(String Element, String Value) throws InterruptedException, IOException {
          DriverDroid.findElement(By.id(Element)).click();
          SelectOption("txtGeneric", Value);
          labelDroid("Seleccionando " + Value);
     }
     
     public void AddContent(String Element, String Value) throws InterruptedException, IOException {
          DriverDroid.findElement(By.id(Element)).sendKeys(Value);
          HideKeys();
          labelDroid("Ingresando valor " + Value);
     }
     
     public void ClickCalcular() throws InterruptedException, IOException {
          DriverDroid.findElement(By.id("btnUser")).click();
          labelDroid("Clic en botón Calcular");
     }
     
     public void ExtractValue() throws InterruptedException, IOException {
          String value = DriverDroid.findElement(By.id("textviewMsg")).getText();
          value = value.replace("La cuota mensual es de $", "").replace(".\nAclaraciones: No incluye seguro de vida.", "");
          value = value.replace(",", "").replace(".", "");
          ClsBuilderExcel.create("CreditoPersonalAPP", value);
          labelDroid("Resultado final y extracción de valor CreditoPersonalAPP");
     }
     
     
     private void HideKeys() {
          try {
                DriverDroid.hideKeyboard();
          }catch(Exception e) {}
     }
}

