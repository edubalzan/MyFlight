package gerenciadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import objetos.Aeronave;

public class GerenciadorAeronaves {
	private ArrayList<Aeronave> aeronaves;

	private static GerenciadorAeronaves gaev = null;

	private GerenciadorAeronaves() {
		aeronaves = new ArrayList<Aeronave>();
	}

	public static GerenciadorAeronaves getInstance() {
		if (gaev == null) {
			gaev = new GerenciadorAeronaves();
		}
		return gaev;
	}

	public void adicionar(Aeronave aev) {
		aeronaves.add(aev);
	}

	public Aeronave buscarPorCodigo(String cod) {
		for (Aeronave aev : aeronaves) {
			if (aev.getCodigo().contains(cod))
				return aev;
		}
		return null;
	}

	public String toString() {
		String gaev = "Aeronaves: ";
		for (Aeronave aev : aeronaves)
			gaev += aev;
		return gaev;
	}

	public boolean readFile(String nomeArq) {
		Path path1 = Paths.get(nomeArq);
		try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
			String line = null;
			line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] dados = line.split(";");
				String cod = dados[0];
				String descricao = dados[1];
				int capacidade = Integer.parseInt(dados[2]);
				Aeronave aev = new Aeronave(cod, descricao, capacidade);
				gaev.adicionar(aev);
			}
		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
		return true;
	}
}