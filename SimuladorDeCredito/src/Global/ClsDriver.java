package Global;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ClsDriver {
     
     public static WebDriver WDriver;
     public static AndroidDriver<MobileElement> DriverDroid;
     
     static boolean active = true;
     static String ruta = "", auxruta = "";
     static int contador = 0;

     
     
     public void SetearDriverWeb() {
          System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
          WDriver = new ChromeDriver();
     }
     
     public void SetearDriverDroid() throws MalformedURLException {
          DesiredCapabilities capabilities = new DesiredCapabilities();
          URL driverUrl = new URL("http://127.0.0.1:4723/wd/hub");
          
          Hashtable<String, String> DTDriver = new Hashtable<String, String>();
          
          DTDriver.put("deviceName", "5203bc18501024df");
          DTDriver.put("platformName", "Android");
          DTDriver.put("appPackage", "com.todo1.mobile");
          DTDriver.put("appActivity", "com.todo1.mobile.ui.contenido.splash");
          DTDriver.put("url", "127.0.0.1");
          DTDriver.put("port", "4723");
          
          capabilities.setCapability("deviceName", DTDriver.get("deviceName"));
          capabilities.setCapability("platformName", DTDriver.get("platformName"));
          capabilities.setCapability("appPackage", DTDriver.get("appPackage"));
          capabilities.setCapability("appActivity", DTDriver.get("appActivity"));
          capabilities.setCapability("noReset", true);
          
          DriverDroid = new AndroidDriver<MobileElement>(driverUrl, capabilities);
          DriverDroid.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     }
          
     
     public void CreateEvidences(String NameCP) throws InterruptedException{
          File archivo;
          contador = 0;
          if(active) {
                Date hora = new Date();
                SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd-hhmmss");
                auxruta = "D:/" + formateador.format(hora);
                archivo = new File(ruta);
                archivo.mkdir();
                active = false;
          }
          ruta = auxruta+"/"+NameCP;
          archivo = new File(ruta);
          archivo.mkdir();
    }
     
     public void label(String label) throws InterruptedException, IOException {
              contador = contador + 1;
              File screenshot = ((TakesScreenshot)WDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot,  new File(ruta.toString()+"/"+contador+" "+label.toString()+".jpg"));
     }
     
      public void labelDroid(String label) throws InterruptedException, IOException {
              contador = contador + 1;
              File screenshot = ((TakesScreenshot)DriverDroid).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot,  new File(ruta.toString()+"/"+contador+" "+label.toString()+".jpg"));
     }
}

