package testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import navegadores.Executa;
import pages.HomePage;

public class DesafioPageTeste {

	HomePage page = new HomePage();
	
	@BeforeEach
	public void iniciarTeste() {
		Executa.abrirNavegador();
	}
	
	@Test
	public void preencherDadosCorretos() {
		page.selecionarEstado("S");
		page.opcaoTermos("sim");
		page.passarMouse();
		page.preencherFormulario();
		page.botaoClicarDuasVezes();
		page.validarInputsHabilitados();
		page.limparCampo();
		page.validarAlertDe5Segundos();
	}

	
}
