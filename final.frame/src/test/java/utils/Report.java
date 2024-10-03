package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {

  private static com.aventstack.extentreports.ExtentReports extent;

  private static ExtentTest test; // gerenciar testes

  private static ExtentSparkReporter sparkReporter; // gerar relatorios no gformato html

  public static void setupreport() {

    // inicializar o ExtentSparkReporter com o caminho com o arquivo html

    sparkReporter = new ExtentSparkReporter("./relatorios/relatorio.html");

    // configurar o titulo do relatorio

    sparkReporter.config().setDocumentTitle("Relatório de teste");

    // configurar o nome do relatorio

    sparkReporter.config().setReportName("Relatório de execução de testes");

    // defina o tema o relatório para dark ou Standard

    sparkReporter.config().setTheme(Theme.DARK);

    // inicializa a instancia do ExtentsReports

    extent = new com.aventstack.extentreports.ExtentReports();

    // Anexa a configuração Spark ao ExtentReport

    extent.attachReporter(sparkReporter);

    extent.setSystemInfo("sistema Operacional", "Windows");
    extent.setSystemInfo("Ambiente de teste", "selenium com Junit");

  }

  // Metodo iniciar um teste
  public static void statrTest(String nomeDoTeste) {

    test = extent.createTest(nomeDoTeste);

  }

  // Metodo para finalizar e salvar o relatorio
  public static void tearDownReport() {
    // salva o relatorio e encerra a execução
    extent.flush();
  }

  // metodo para registrar falhas
  public static void logFail(String mensagem) {
    test.fail(mensagem);

  }
  
  // metodo para registra informações
  public static void logInf(String mensagem) {
    test.info(mensagem);

  }

}
