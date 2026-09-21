import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Atividade {
    WebDriver driver;

    @BeforeEach
    public void antes() throws InterruptedException {
        driver = new ChromeDriver();

        driver.get("https://www.ifpe.edu.br");

        // Maximizar janela
        driver.manage().window().maximize();

        // fechar pop
        driver.findElement(By.cssSelector(
                "body > div.ays-pb-modals.av_pop_modals_6.ays-pb-close-popup-with-esc > div.ays-pb-modal.ays-pb-modal_6.ays-popup-box-main-box.ays-pb-bg-styles-mobile_6.ays-pb-border-mobile_6.fadeIn > div.ays-pb-modal-close.ays-pb-modal-close_6.ays-pb-close-button-delay.ays_pb_pause_sound_6 > svg > path:nth-child(2)"))
                .click();

        // entrar no campus Jaboatão
        driver.findElement(By.linkText("Campus")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("JABOATÃO DOS GUARARAPES")).click();

        // entrar no campus Ensino
        Thread.sleep(1000);
        driver.findElement(
                By.cssSelector("#menu-principal > li > ul > li.page_item.page-item-1329.page_item_has_children > a"))
                .click();

        // entrar no campus Monitoria
        Thread.sleep(1000);
        driver.findElement(By.linkText("Monitoria")).click();
    }

    @AfterEach
    public void fim() throws InterruptedException {

        // Dar uma pausa de 2 segundos
        Thread.sleep(2000);

        // Fechar
        driver.quit();

    }

    @Test
    @DisplayName("Abrir Edital")
    public void Teste01() throws InterruptedException {

        // entrar no Edital
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body > section > div > main > article > div > ul:nth-child(13) > li > a"))
                .click();

    }

    @Test
    @DisplayName("Comparar Data")
    public void teste02() throws InterruptedException {

        // imprimir o texto
        Thread.sleep(1000);
        WebElement texto = driver.findElement(By.cssSelector(
                "body > section > div > main > article > div > table > tbody > tr:nth-child(2) > td:nth-child(3) > p > strong"));

        assertEquals("Tarde e Noite", texto.getText());

    }

}
