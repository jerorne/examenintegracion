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

public class LoginSteps {
	private WebDriver driver;
    
    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:/WebDriver/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    
    @Given("el usuario esta en la pagina de inicio de sesion")
    public void el_usuario_esta_en_la_pagina_de_inicio_de_sesion() {
        driver.get("http://localhost:8081/ReservaHora/");
    }

    @When("el usuario introduce {string} en el campo nombreUsuario y {string} en el campo password")
    public void el_usuario_introduce_en_el_campo_nombreUsuario_y_en_el_campo_password(String username, String password) {
        driver.findElement(By.id("nombreUsuario")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Iniciar Sesión']")).click();
    }

	@Then("el usuario debería ver un mensaje {string}")
	public void el_usuario_debería_ver_un_mensaje(String expectedMessage) {
	    WebElement mensaje = driver.findElement(By.cssSelector("p[style='color: red;']"));
	    assertEquals(expectedMessage, mensaje.getText());
	}
	
	@Then("el usuario debería ser redirigido a la página de inicio")
	public void el_usuario_debería_ser_redirigido_a_la_página_de_inicio() {
	    assertTrue(driver.getCurrentUrl().contains("paginaInicio"));
	}

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
