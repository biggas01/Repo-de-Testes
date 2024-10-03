package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metodos.Metodos;
import navegadores.Executa;

public class DesafioUiTeste {


	Metodos mt = new Metodos();
	
	
	@BeforeEach
	public void setUp() {
		Executa.abrirNavegador();
	}
	
	@Test
	public void validarUrl() {
		mt.validarUrl("https://desafio.ui.e2etreinamentos.com.br/");
		
		
	}
	
	@AfterEach
	public void finalizar() {
		Executa.fecharNavegador();
	}
	
}
