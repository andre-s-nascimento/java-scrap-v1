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
 * Busca por um item em um site via selenium/por xPath
 *
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Inicializa os parametros de busca
        String webSite = "https://e2etec.com.br";
        String searchPattern = "//div[@id='panel-w5f11b62f8fe0c-0-0-0']/div[1]/div[1]/p[1]";
        
        //Inicializa o recurso selenium
        WebDriver driver = new FirefoxDriver();
        driver.get(webSite);
        WebElement telefoneEmail = driver.findElement(By.xpath(searchPattern));
        Thread.sleep(2000);

        //Prepara os dados para criar o arquivo txt
        String fileText = telefoneEmail.getText();
        String path = "c:\\temp";
        Path pathFile = Paths.get(path);
        String fileName = "e2etec_java.txt";

        // verificar se existe o c:\temp e criar
        Files.createDirectories(pathFile);

        try (FileWriter fileToSave = new FileWriter(pathFile + File.separator + fileName)) {
            fileToSave.write(fileText);
        }
        //Encerra o recurso selenium
        driver.quit();
    }
}
