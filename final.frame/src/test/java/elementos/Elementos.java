package elementos;

import org.openqa.selenium.By;

public class Elementos {

	// Abrir conta
	public By cpf = By.id("cpf-input");
	public By btnContinuar = By.xpath("//button[text()='Continuar']");

	// Dados Pessoais
	public By nome = By.xpath("//input[@name='firstName']");
	public By sobrenome = By.xpath("//input[@name='lastName']");
	public By email = By.xpath("//input[@name='email']");
	public By dataNascimento = By.xpath("//input[@name='dataBirthday']");
	public By rg = By.xpath("//input[@name='rg']");
	public By telefone = By.xpath("//input[@name='phoneNumber']");
	public By endereco = By.xpath("//input[@name='addres']");
	public By cep = By.xpath("//input[@name='cep']");
	public By numero = By.xpath("//input[@name='number']");
	public By complemento = By.xpath("//input[@name='complement']");
	public By estado = By.xpath("//input[@name='state']");
	public By cidade = By.xpath("//input[@name='city']");
	public By btnAvancar = By.xpath("//button[@class='form-button']");

	// Dados Profissionais
	public By grupoAtual = By.xpath("//*[@name='actualGroup'");
	public By primeiroGrupo = By.xpath("//*[@name='firstGruop'");
	public By cargo = By.xpath("//*[@name='job'");
	public By salario = By.xpath("//*[@placeholder='Salário'");
	public By emailProfissional = By.xpath("//*[@name='professionalEmail'");
	public By btnEnviar = By.xpath("//*[@id='btnEnviar']");

	// Criação de senha
	public By senha = By.xpath("//input[@placeholder='Senha']");
	public By confirmarSenha = By.xpath("//*[@name='password");
	public By btnCadastrar = By.xpath("//*[text()='Cancelar']");

	// Botões Avulsos
	public By btnFecharX = By.xpath("//*[@class='close-button ");
	public By btnVoltar = By.xpath("//*[@id='btnVoltar'");
	public By btnCancelar = By.xpath("//*[text()='Cancelar']");

	// Login
	public By user = By.xpath("//input[@name='username']");

}
