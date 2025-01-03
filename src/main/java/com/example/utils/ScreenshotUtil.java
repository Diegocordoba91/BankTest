package com.example.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String fileName) {
        
        // Convertir WebDriver a TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Tomar la captura de pantalla como un archivo
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Definir la ubicación donde se guardará la captura

        File destFile = new File("src/test/resources/screenshots/" + fileName+".png");

        try {
            // Crear el directorio si no existe
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            // Copiar el archivo al destino
            FileUtils.copyFile(srcFile, destFile);
            
            System.out.println("Captura de pantalla guardada en: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al guardar la captura de pantalla: " + e.getMessage());
        }
    }
    
}
