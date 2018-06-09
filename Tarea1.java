package Ejercicios;

import com.qalabs.seleniumbasics.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.List;

public class Tarea1 {

    public static void main(String[] args) throws InterruptedException, NullPointerException {

        String browser = "chrome";

        WebDriver myDriver = WebDriverFactory.getDriver(browser);

        //ir a URL de Google
        myDriver.get("https://www.google.com.mx/");

        // Buscar la barra de input por nombre
        WebElement searchBar = myDriver.findElement(By.name("q"));
        searchBar.sendKeys("Selenium");

        // Presionar Enter
        searchBar.sendKeys(Keys.RETURN);

        // Crear lista para traer el texto del link de los resultados
        List<WebElement> aElements = myDriver.findElements(By.xpath("//div[@class = 'rc']/h3[@class = 'r']/a"));

        // Crear lista para traer el texto del contenido de los resultados
        List<WebElement> textElements = myDriver.findElements(By.xpath("//span[@class = 'st']"));

        WebElement element = null;

        // Iteracion de las 2 listas para traer el contenido de cada una, resultados hasta 3 paginas
        for(int index = 0; index < 3; index++){

            element = aElements.get(index);
            System.out.println(element.getText());
            System.out.println(element.getAttribute("href"));
            element = textElements.get(index);
            System.out.println(element.getText());
            System.out.println();

        }

        Thread.sleep(5000);

        myDriver.quit();
    }
}