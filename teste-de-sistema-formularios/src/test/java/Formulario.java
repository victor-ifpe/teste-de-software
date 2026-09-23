import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Formulario {

  @Test
  @Disabled
  public void teste01() throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver
        .get("file:///C:/Users/Aluno/Documents/GitHub/teste-de-software/teste-de-sistema-formularios/formulario.html");

    // Titulo
    Thread.sleep(2000);
    driver.findElement(By.className("textoo")).sendKeys("Título do filme");

    // Genero
    Thread.sleep(2000);
    driver.findElement(By.id("idgenero")).sendKeys("Suspence");

    // Ano do Radio
    Thread.sleep(2000);
    List<WebElement> radios = driver.findElements(By.name("radioAno"));
    for (WebElement radio : radios) {
      if (radio.getAttribute("value").equals("2022")) {
        radio.click();
      }
    }

    // CheckboxOscar
    Thread.sleep(2000);
    List<WebElement> checkboxOscar = driver.findElements(By.name("checkboxOscar"));
    for (WebElement checkbox : checkboxOscar) {
      if (checkbox.getAttribute("id").equals("idoscar")) {
        checkbox.click();
      }
      if (checkbox.getAttribute("id").equals("idglo")) {
        checkbox.click();
      }
    }

    // Descrição
    Thread.sleep(2000);
    driver.findElement(By.id("iddescricao")).sendKeys(
        "Exemplo de texto para n sei oq?");

    // Cadastrar
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("body > button")).click();

    // Verificar
    Thread.sleep(2000);
    String respostaTitulo = driver.findElement(By.id("resTitulo")).getText();
    assertEquals("Formulário cadastrado com sucesso!", respostaTitulo);

    Thread.sleep(2000);
    driver.quit();
  }

  @Test
  @DisplayName("Aula 02 - Atividade")
  public void Aula02() throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver
        .get("https://practice-automation.com/form-fields/");

    // Nome
    Thread.sleep(1000);
    driver.findElement(By.id("name-input")).sendKeys("Pedro");

    // Senha
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("#feedbackForm > label:nth-child(3) > input[type=password]")).sendKeys("123456");

    // Favorite Drink
    Thread.sleep(1000);
    List<WebElement> favs_drinks = driver.findElements(By.name("fav_drink"));
    for (WebElement fav_drink : favs_drinks) {
      if (fav_drink.getAttribute("value").equals("Milk")) {
        fav_drink.click();
      }
    }

    // Favorite Color
    Thread.sleep(1000);
    List<WebElement> favs_colors = driver.findElements(By.name("fav_color"));
    for (WebElement fav_color : favs_colors) {
      if (fav_color.getAttribute("value").equals("Red")) {
        fav_color.click();
      }
    }

    // Like Automation?
    Thread.sleep(1000);
    driver.findElement(By.id("automation")).sendKeys("Yes");

    // Email
    Thread.sleep(1000);
    driver.findElement(By.id("email")).sendKeys("Teste@gmail.com");

    // Message
    Thread.sleep(1000);
    driver.findElement(By.id("message")).sendKeys(
        "Exemplo de texto para alguma coisa");

    Thread.sleep(1000);
    WebElement elemento = driver.findElement(By.id("submit-btn"));
    new Actions(driver)
        .scrollToElement(elemento)
        .perform();

    // Submit
    Thread.sleep(1000);
    driver.findElement(By.id("submit-btn")).click();

    // Verificar
    Thread.sleep(1000);

    String textoDoAlert = driver.switchTo().alert().getText();
    assertEquals("Message received!", textoDoAlert);

    Thread.sleep(1000);
    driver.quit();
  }

}