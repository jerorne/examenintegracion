package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import static org.junit.Assert.*;

public class AgendaSteps {
	
	private WebDriver driver;
	
	@Before
    public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:/WebDriver/geckodriver.exe");
        driver = new FirefoxDriver();
    }
	
    @Given("el usuario está en la página de agendar cita")
    public void el_usuario_está_en_la_página_de_agendar_cita() {
        driver.get("http://localhost:8081/ReservaHora/agendar.jsp");
    }

    @When("el usuario introduce el ID de mascota {string}")
    public void el_usuario_introduce_el_ID_de_mascota(String idMascota) {
        driver.findElement(By.id("idMascota")).sendKeys(idMascota);
    }

    @When("el usuario introduce el Rut del Dueño {string}")
    public void el_usuario_introduce_el_Rut_del_Dueño(String rutDueño) {
        driver.findElement(By.id("rutDueno")).sendKeys(rutDueño);
    }

    @When("el usuario introduce el Nombre de la Mascota {string}")
    public void el_usuario_introduce_el_Nombre_de_la_Mascota(String nombreMascota) {
        driver.findElement(By.id("nombreMascota")).sendKeys(nombreMascota);
    }

    @When("el usuario introduce la Hora {string}")
    public void el_usuario_introduce_la_Hora(String hora) {
        driver.findElement(By.id("hora")).sendKeys(hora);
    }

    @When("el usuario introduce la Fecha {string}")
    public void el_usuario_introduce_la_Fecha(String fecha) {
        WebElement fechaInput = driver.findElement(By.id("fecha"));
        
        // Limpia cualquier valor existente en el campo de fecha
        fechaInput.clear();

        // Separa la fecha en día, mes y año
        String[] partesFecha = fecha.split("/");
        String dia = partesFecha[0];
        String mes = partesFecha[1];
        String anio = partesFecha[2];

        // Envía las teclas correspondientes para ingresar la fecha en el formato correcto
        fechaInput.sendKeys(dia);
        fechaInput.sendKeys("/");
        fechaInput.sendKeys(mes);
        fechaInput.sendKeys("/");
        fechaInput.sendKeys(anio);
    }


    @When("el usuario presiona el botón {string}")
    public void el_usuario_presiona_el_botón(String buttonText) {
        driver.findElement(By.xpath("//button[text()='" + buttonText + "']")).click();
    }

    @Then("el usuario de la agenda debería ver un mensaje {string}")
    public void el_usuario_de_la_agenda_debería_ver_un_mensaje(String expectedMessage) {
        WebElement mensaje = driver.findElement(By.cssSelector("p.success-message")); // Ajusta el selector CSS según tu aplicación
        assertEquals(expectedMessage, mensaje.getText());
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
