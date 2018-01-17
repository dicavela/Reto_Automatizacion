package Global;

import  java.io.*;
import java.text.NumberFormat;

import org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ClsBuilderExcel {
     
     static String[] title = new String[4];
     static String[] value = new String[4];
     static int contador = 0;
     
     public static void create(String Titulo, String Valor) {
        try {
               if (contador <= 3) {
                     title[contador] = Titulo;
                     value[contador] = Valor;
                     contador = contador + 1;
               }
                 if(contador == 4) {
                     File fileName = new File("..\\Factura Valor Cuota.xls"); //ALERT: it will always created when are the project
                     HSSFWorkbook workbook = new HSSFWorkbook();
                    HSSFSheet sheet = workbook.createSheet("Resultado");
                      
                      HSSFRow rowhead = sheet.createRow((short)0);
                      HSSFRow row = sheet.createRow((short)1);
                      
                      NumberFormat formato = NumberFormat.getInstance();
                      formato.setMinimumFractionDigits(2);
                      
                      int best = Integer.valueOf(value[0]);
                      for (int i = 1; i < 4; i++) {
                          if (Integer.valueOf(value[i]) < best) {
                               best = Integer.valueOf(value[i]);
                          }
                      }
                      for (int i = 0; i < 4; i++) {
                            rowhead.createCell(i).setCellValue(title[i]);
                            row.createCell(i).setCellValue(formato.format(Double.valueOf(value[i])/100));
                      }
                      rowhead.createCell(4).setCellValue("Mejor Cuota");
                      row.createCell(4).setCellValue(formato.format(Double.valueOf(best)/100));
                    FileOutputStream fileOut = new FileOutputStream(fileName);
                      workbook.write(fileOut);
                      
                      fileOut.close();
                 }
        } catch ( Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }
}

