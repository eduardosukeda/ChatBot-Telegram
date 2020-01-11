package br.com.fiap.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeituraTextoService {

	private static String texto;

	public LeituraTextoService(String path) throws IOException {
		texto = "";

		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("resources/" + path + ".txt"), "UTF-8"));

		String linha;
		while ((linha = br.readLine()) != null) {

			String[] arrayLinha = linha.split(";");
			setTexto(arrayLinha[0] + "\n" + arrayLinha[1] + "\n" + arrayLinha[2] + "\n\n");
		}
		br.close();
	}

	public static String getTexto() {
		return texto;
	}

	public static void setTexto(String _texto) {
		texto += _texto;
	}
}
