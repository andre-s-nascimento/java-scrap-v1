package snascimento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        
        System.setProperty("webdriver.gecko.driver", "c:\\geckodriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://e2etec.com.br");

        WebElement telefoneEmail = driver
                .findElement(By.xpath("//div[@id='panel-w5f11b62f8fe0c-0-0-0']/div[1]/div[1]/p[1]"));

        String fileText = telefoneEmail.getText();
        
        System.out.println("------------------------");
        System.out.println(fileText);
        System.out.println("------------------------");

        String path = "c:\\temp";
        Path pathFile = Paths.get(path);
        String fileName = "e2etec_java.txt";

        // verificar se existe o c:\temp e criar
        Files.createDirectories(pathFile);

        try (FileWriter fileToSave = new FileWriter(pathFile + File.separator + fileName)) {
            fileToSave.write(fileText);
        }

        driver.quit();
    }
}
