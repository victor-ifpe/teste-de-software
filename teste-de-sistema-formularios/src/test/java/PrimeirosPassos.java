import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrimeirosPassos {
	WebDriver driver;
	@BeforeEach
	public void antes() {
		driver = new ChromeDriver();
		//Maximizar janela.
		driver.manage().window().maximize();	
	}
	@AfterEach
	public void fim() throws InterruptedException {
		//Dar uma pausa de 2 segundos.
		Thread.sleep(2000);
		//Fechar.
		driver.quit();		
	}
	@Test
	@DisplayName("Primeiros passos com o google.com")
	@Disabled
	public void teste01() throws InterruptedException {
		driver.get("http://www.google.com.br");
		//campoPesquisa.sendKeys("ifpe Jaboatão");
		//driver.findElement(By.id("ti6dpd")).sendKeys("ifpe Jaboatão");
		driver.findElement(By.name("q")).sendKeys("ifpe Jaboatão" + Keys.ENTER);
		//driver.findElement(By.cssSelector("body > div.plsC5e.RqyYHe > div.acUsEb.Q6KTif.KEY6ib > form > div:nth-child(1) > div > div.FPdoLc.T14B5e.iThwld > center > input.gNO89b")).click();

	}
	@Test
	@DisplayName("Primeiros passos com o ifpe.edu.br")
	@Disabled
	public void teste02() throws InterruptedException {
		driver.get("https://www.ifpe.edu.br");
		//Aguardar 2 segundos.
		Thread.sleep(2000);
		//Fechar pop
		driver.findElement(By.cssSelector("body > div.ays-pb-modals.av_pop_modals_6.ays-pb-close-popup-with-esc > div.ays-pb-modal.ays-pb-modal_6.ays-popup-box-main-box.ays-pb-bg-styles-mobile_6.ays-pb-border-mobile_6.fadeIn > div.ays-pb-modal-close.ays-pb-modal-close_6.ays-pb-close-button-delay.ays_pb_pause_sound_6 > svg > path:nth-child(2)")).click();
		//entrar no campus jaboatão
		driver.findElement(By.linkText("Campus")).click();
		driver.findElement(By.partialLinkText("Jaboatão")).click();
		//entrar em cursos
		driver.findElement(By.cssSelector("#menu-principal > li > ul > li.page_item.page-item-1340.page_item_has_children > a")).click();
		WebElement titulo = driver.findElement(By.cssSelector("body > section > div > main > article > h2"));
		assertEquals("Cursos", titulo.getText());	
	}
}
