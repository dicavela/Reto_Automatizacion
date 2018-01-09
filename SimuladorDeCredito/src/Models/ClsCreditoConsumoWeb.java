package Models;

import java.io.IOException;
import java.text.NumberFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import Global.ClsBuilderExcel;
import Global.ClsDriver;

public class ClsCreditoConsumoWeb extends ClsDriver{ 
     
     public void LoadPage(String NameCP) throws InterruptedException {
          SetearDriverWeb();
          WDriver.get("https://www.grupobancolombia.com/wps/portal/personas");
          WDriver.manage().window().maximize();
          CreateEvidences(NameCP);
     }
     
     public void Search(String busqueda) throws InterruptedException, IOException {
          WDriver.findElement(By.id("terminoBusqueda")).sendKeys(busqueda);
          WDriver.findElement(By.id("terminoBusqueda")).sendKeys(Keys.ENTER);
          label("buscar simuladores");
     }
     
     public void SelectLink(String LnkContenido) throws InterruptedException, IOException {
          Thread.sleep(2000);
          WDriver.findElement(By.linkText(LnkContenido)).click();
          label("click en Simulador Credito de Consumo");
     }
     
     public void SelectionOption(String NameElemento, String Value) throws InterruptedException, IOException {
          WDriver.findElement(By.name(NameElemento)).sendKeys(Keys.TAB);
          WDriver.findElement(By.name(NameElemento)).sendKeys(Value);
          label("Selecionar en comboBox " + Value);
     }
     
     public void ChkSafeEmployee() throws InterruptedException, IOException {
          WDriver.findElement(By.name("checkSeguroDesempleo")).click();
          label("Ckecking checkbox Seguro de Empleado");
     }
     
     public void BtnSimular() throws InterruptedException, IOException {
          WDriver.findElement(By.xpath("//*[@id='sim-detail']/form/div[8]/button")).click();
          label("Click en Botón Simular");
     }
     
     public void ExtractValue() throws InterruptedException, IOException {
          String ValorCuota = WDriver.findElement(By.xpath("//*[@id='sim-results']/div[1]/table/tbody/tr[6]/td[2]")).getText();
          ValorCuota = ValorCuota.replace("$", "").replace(",", "").replace(".", "");
          NumberFormat formato = NumberFormat.getInstance();
        formato.setMinimumFractionDigits(2);
          ClsBuilderExcel.create("Consumo", ValorCuota);
          label("Resultado final y extracción de valor Consumo");
     }
}
