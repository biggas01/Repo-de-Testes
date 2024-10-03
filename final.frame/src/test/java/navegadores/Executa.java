package navegadores;

import org.openqa.selenium.chrome.ChromeDriver;

import drivers.Drivers;

public class Executa extends Drivers{

	public static void abrirNavegador() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://desafio.ui.e2etreinamentos.com.br/");
	}

	public static void fecharNavegador() {
		driver.quit();
		
	}

	
	
}
