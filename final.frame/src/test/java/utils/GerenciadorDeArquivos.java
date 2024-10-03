package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class GerenciadorDeArquivos {

	public String lerArquivoGeral(String arquivo) {
		StringBuilder conteudo = new StringBuilder();
		try(BufferedReader reader = new BufferedReader(new FileReader("./src/test/resources/arquivos/" + arquivo))){
			String linha;
			while((linha = reader.readLine())!=null) {
				conteudo.append(linha).append("\n");
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return conteudo.toString();
	}
	

public String lerArquivoPdf (String arquivo) {
	
	StringBuilder conteudo = new StringBuilder();
	try (PDDocument documento =  PDDocument.load(new File("./src/test/resource/arquivos" + arquivo))){
		
		
	} catch (IOException e) {	
		e.printStackTrace();
	}
	
	
	return conteudo.toString();
}



}
