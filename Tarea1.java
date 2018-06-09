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

        //ir a URL de Google y Validar si la URL es correcta
        myDriver.get("https://www.google.com.mx/");

        // Buscar la barra de input por nombre
        WebElement searchBar = myDriver.findElement(By.name("q"));
        searchBar.sendKeys("Selenium");

        searchBar.sendKeys(Keys.RETURN);

        List<WebElement> aElements = myDriver.findElements(By.xpath("//div[@class = 'rc']/h3[@class = 'r']/a"));
        List<WebElement> textElements = myDriver.findElements(By.xpath("//span[@class = 'st']"));

        WebElement element = null;

        for(int index = 0; index < 3; index++){ //For Normal

            element = aElements.get(index);
            System.out.println(element.getText());
            element = textElements.get(index);
            System.out.println(element.getText());
            System.out.println();

        }





        //aElements.forEach( element -> {

        //    System.out.println(aElements.size());
        //});

        Thread.sleep(5000);

        myDriver.quit();
    }
}