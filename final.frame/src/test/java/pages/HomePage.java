package pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;

import metodos.Metodos;
import utils.MassaDeDados;

public class HomePage {

	Metodos mt = new Metodos();
	MassaDeDados massa = new MassaDeDados();

	By selecionar = By.xpath("//select");

	By checkSim = By.xpath("//*[@value='sim']");
	By checkNao = By.xpath("//*[@value='nao']");

	By mouseOver = By.xpath("//*[@class='hover-alert']");

	By btnAbrirNovaAba = By.xpath("//*[text()='Abrir Nova Aba']");
	By btnAbrirNovaJanela = By.xpath("//*[text()='Abrir Nova Janela']");
	By msgNovaPagina = By.xpath("//h1");

	By nome = By.xpath("//form//label[1]/input");
	By email = By.xpath("//form//label[2]/input");
	By telefone = By.xpath("//form//label[3]/input");
	By endereco = By.xpath("//form//label[4]/input");
	By cidade = By.xpath("//form//label[5]/input");
	By upload = By.xpath("//input[@type='file']");
	By btnEnviar = By.xpath("//*[@type='submit']");

	By btnClicarDuasVezes = By.xpath("//*[text()='Clique duas vezes aqui']");

	By desabilitado = By.xpath("//label[contains(text(), 'Campo')][1]/input");
	By habilitado = By.xpath("//label[contains(text(), 'Campo')][2]/input");
	
	By campoLimpar = By.xpath("//*[@id='campoLimpar']");
	By btnVerificar = By.xpath("//*[text()='Verificar']");
	By msgParabens = By.xpath("//h2[text()='Parabéns!']");

	public void selecionarEstado(String estado) {
		mt.escrever(selecionar, estado);
	}

	public void opcaoTermos(String checkbox) {

		if (checkbox.equalsIgnoreCase("sim")) {
			mt.clicar(checkSim);
		} else if (checkbox.equalsIgnoreCase("nao")) {
			mt.clicar(checkNao);
		}
	}

	public void passarMouse() {
		mt.mouseOver(mouseOver);
		mt.clicarAlert();
	}

	public void novaAba() {
		mt.clicar(btnAbrirNovaAba);
		mt.atualizarPagina();
	}

	public void preencherFormulario() {
		mt.escrever(this.nome, massa.gerarPrimeiroNome());
		mt.escrever(this.email, massa.gerarEmail());
		mt.escrever(this.telefone, "(11) 91234-4321");
		mt.escrever(this.endereco, massa.gerarEndereco());
		mt.escrever(this.cidade, massa.gerarCidade());
		mt.uploadArquivo(upload, "C:\\Users\\Thiago Avelino\\Desktop\\arquivopdf.pdf");
		mt.clicar(btnEnviar);
	}

	public void botaoClicarDuasVezes() {
		mt.duploClique(btnClicarDuasVezes);
		mt.clicarAlert();
	}

	public void validarInputsHabilitados() {
		mt.validarHabilitacao(desabilitado);
		mt.validarHabilitacao2(habilitado);

	}
	
	public void limparCampo () {
		mt.clear(campoLimpar);
		mt.clicar(btnVerificar);
		mt.validarTexto(msgParabens, "Parabéns!");
		
	}
	

	public void validarAlertDe5Segundos() {
		mt.validarAlert("Pop-up aberto após 5 segundos!");
	}
}
