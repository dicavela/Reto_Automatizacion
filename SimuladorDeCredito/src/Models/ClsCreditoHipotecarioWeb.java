package Models;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import Global.ClsBuilderExcel;
import Global.ClsDriver;

public class ClsCreditoHipotecarioWeb extends ClsDriver{
     
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
     
     public void BtnSimular() throws InterruptedException, IOException {
          WDriver.findElement(By.xpath("//*[@id='sim-detail']/div/button")).click();
          label("Click en Botón Simular");
     }
     
     public void ExtractValue() throws InterruptedException, IOException {
          String CuotaMensual = WDriver.findElement(By.xpath("//*[@id='sim-results']/div[1]/table/tbody/tr[17]/td[4]")).getText();
          String SeguroDeVida = WDriver.findElement(By.xpath("//*[@id='sim-results']/div[1]/table/tbody/tr[21]/td[2]")).getText();
          String SeguroDeIncendio = WDriver.findElement(By.xpath("//*[@id='sim-results']/div[1]/table/tbody/tr[22]/td[2]")).getText();
          CuotaMensual = CuotaMensual.replace("$", "").replace(" ", "").replace(",", "").replace(".", "");
          SeguroDeVida = SeguroDeVida.replace("$", "").replace(" ", "").replace(",", "").replace(".", "");
          SeguroDeIncendio = SeguroDeIncendio.replace("$", "").replace(" ", "").replace(",", "").replace(".", "");
          int calculo = Integer.valueOf(CuotaMensual) + Integer.valueOf(SeguroDeVida) + Integer.valueOf(SeguroDeIncendio);
          ClsBuilderExcel.create("Inmobiliaria", String.valueOf(calculo));
          label("Resultado final y extracción de valor Inmobiliaria");
     }
}

