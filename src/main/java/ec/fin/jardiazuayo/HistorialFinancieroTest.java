package ec.fin.jardiazuayo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class HistorialFinancieroTest {
    public static void main(String[] args) {
        WebDriver driver = null;

        try {
          /*  // Configurar opciones de Chrome para Chrome for Testing
            ChromeOptions options = new ChromeOptions();

            // Configuraciones optimizadas para Chrome for Testing
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-web-security");
            options.addArguments("--disable-features=VizDisplayCompositor");

            // URL del ChromeDriver local
            String chromeDriverUrl = "http://host.docker.internal:9515";

            System.out.println("Conectando a ChromeDriver en: " + chromeDriverUrl);
            System.out.println("Usando Chrome for Testing con ChromeDriver compatible");

            // Crear RemoteWebDriver con timeout adecuado
            driver = new RemoteWebDriver(new URL(chromeDriverUrl), options);

            // Configurar timeouts para Selenium 4.x
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

            System.out.println("¡Conexión establecida con éxito!");
            System.out.println("Navegando a Google...");*/
            //Selenium local:
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //Fin local
            // Navegar a Google
            driver.get("https://stdx4.jardinazuayo.fin.ec/portal");

            // Imprimir información de la página
            System.out.println("Título de la página: " + driver.getTitle());
            System.out.println("URL actual: " + driver.getCurrentUrl());
            System.out.println("Tamaño de ventana: " + driver.manage().window().getSize());

            WebElement campo;

            // Login
            campo = driver.findElement(By.id("username"));
            campo.sendKeys("g.chungata", Keys.TAB);
            campo = driver.findElement(By.id("password"));
            //campo.sendKeys("0", Keys.TAB);//Estabilizacion
            campo.sendKeys("0", Keys.TAB);
            campo = driver.findElement(By.id("kc-login"));
            campo.click();
            Thread.sleep(4000);

            // Selección sucursal
            campo = driver.findElement(By.id("mainForm:j_idt86:combo_sucursal"));
            campo.click();
            campo = driver.findElement(By.id("mainForm:j_idt86:combo_sucursal_filter"));
            campo.sendKeys("cuenca", Keys.ENTER);
            campo = driver.findElement(By.id("mainForm:j_idt91"));
            campo.click();
            Thread.sleep(1000);

            // Esperar para que puedas ver la página en tu Chrome local
            System.out.println("Esperando 10 segundos para que veas la página...");
            Thread.sleep(10000);

            System.out.println("¡Navegación completada exitosamente con Chrome for Testing!");

        } catch (Exception e) {
            System.err.println("Error durante la ejecución:");
            e.printStackTrace();


        } finally {
            if (driver != null) {
                System.out.println("Cerrando navegador...");
                driver.quit();
            }
            System.out.println("¡Aplicación terminada!");
        }
    }
}
