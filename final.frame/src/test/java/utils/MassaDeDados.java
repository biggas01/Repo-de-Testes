package utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import com.github.javafaker.Faker;

public class MassaDeDados {

	private Faker faker = new Faker();
	private Random random = new Random();

	public String gerarPrimeiroNome() {

		return faker.name().firstName();
	}

	public String gerarUltimoNome() {

		return faker.name().lastName();
	}

	public String gerarNomeCompleto() {
		return faker.name().fullName();
	}

	public String gerarEmail() {
		return faker.internet().emailAddress();
	}

	public String gerarEndereco() {
		return faker.address().streetAddress();
	}

	public String gerarDataNascimento() {
		Date dataNascimento = faker.date().birthday(18, 86);

		// converter para localdate
		LocalDate localDate = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		// Formatar a data no padrao "ddMMyyyy"
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

		return localDate.format(formatter);

	}

	public String gerarRg() {

		return faker.number().digits(10);
	}

	public String gerarEstado() {
		String[] estadosBrasileiros = { "SP", "RJ", "BA", "PB", "MG" };
		int index = random.nextInt(estadosBrasileiros.length);
		return estadosBrasileiros[index];
	}
	
	public String gerarCidade() {
		return faker.address().city();
	}

}
