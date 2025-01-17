package metodos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.Drivers;

public class Metodos extends Drivers {

	public void clicar(By elemento) {
		driver.findElement(elemento).click();

	}

	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);

	}

	public void aguardarElemento(By elemento) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
	}

	public void validarTexto(By elemento, String textoEsperado) {
		assertEquals(driver.findElement(elemento).getText(), textoEsperado);

	}

	public void tirarPrint(String nomePasta, String nomeTeste) {

		File scrPrint = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrPrint, new File("./evidencias/" + nomePasta + "/" + nomeTeste + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void trocarDeAba() {
		String primeiraAba = driver.getWindowHandle();
		Set<String> todasAbas = driver.getWindowHandles();
		for (String ultimaAba : todasAbas) {
			if (!ultimaAba.equals(primeiraAba)) {
				driver.switchTo().window(ultimaAba);
			}
		}

	}

	

	public void validarAlert(String textoEsperado) {
		pause(5000);
		Alert alerta = driver.switchTo().alert();
		assertEquals(textoEsperado, alerta.getText());

	}
	
	public void validarHabilitacao (By elemento) {
		WebElement el = driver.findElement(elemento);
		
		assertFalse(el.isEnabled());
		
	}
	
	public void validarHabilitacao2 (By elemento) {
		WebElement el = driver.findElement(elemento);
		
		assertTrue(el.isEnabled());
		
	}
	

	public void clicarAlert() {
		Alert alerta = driver.switchTo().alert();
		alerta.accept();
	}

	public void scrooll(String nmrScroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + nmrScroll + ")");
	}

	public void zoom(String valorZoom) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.boddy.style.zoom='" + valorZoom + "%'");
	}

	public void moverEClicar(By elemento) {
		WebElement el = driver.findElement(elemento);
		Actions actions = new Actions(driver);
		actions.moveToElement(el).click().perform();

	}

	public void duploClique(By elemento) {
		WebElement el = driver.findElement(elemento);
		Actions actions = new Actions(driver);
		actions.doubleClick(el).perform();
	}

	public void mouseOver(By elemento) {
		WebElement el = driver.findElement(elemento);
		Actions actions = new Actions(driver);
		actions.moveToElement(el).perform();
	}

	public void tab() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).perform();
	}

	public void enter() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
	}

	public void end() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
	}

	public void enter(By elemento) {
		driver.findElement(elemento).sendKeys(Keys.ENTER);

	}

	public void digitarPausadamente(By elemento, String texto) {

		for (char c : texto.toCharArray()) {
			driver.findElement(elemento).sendKeys(String.valueOf(c));
			pause(1000);
		}

	}

	public void clicarESegurar(By elemento) {
		WebElement el = driver.findElement(elemento);
		Actions actions = new Actions(driver);
		actions.clickAndHold(el);
	}

	public void submit(By elemento) {
		driver.findElement(elemento).submit();
	}

	public void clear(By elemento) {
		driver.findElement(elemento).clear();
	}

	public void validarTitle(String tituloEsperado) {
		assertEquals(driver.getTitle(), tituloEsperado);
	}

	public void voltarPagina() {
		driver.navigate().back();
	}

	public void avancarPagina() {
		driver.navigate().forward();
	}

	public void atualizarPagina() {
		driver.navigate().refresh();
	}

	public void uploadArquivo(By elemento, String path) {
		driver.findElement(elemento).sendKeys(path);
	}

	public void pause(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fecharPopUp(By elemento) {
		int contador = 5;
		WebElement el = driver.findElement(elemento);
		while (el.isDisplayed() && contador > 0) {
			clicar(elemento);
			contador--;
		}
	}

	public void validarUrl(String url) {
		assertEquals(url, driver.getCurrentUrl());
	}

}
