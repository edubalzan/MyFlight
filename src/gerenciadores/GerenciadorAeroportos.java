package gerenciadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import objetos.Aeroporto;
import objetos.Geo;

public class GerenciadorAeroportos {
	private ArrayList<Aeroporto> aeroportos;

	private static GerenciadorAeroportos gaer = null;

	private GerenciadorAeroportos() {
		this.aeroportos = new ArrayList<Aeroporto>();
	}

	public static GerenciadorAeroportos getInstance() {
		if (gaer == null) {
			gaer = new GerenciadorAeroportos();
		}
		return gaer;
	}

	public void adicionar(Aeroporto aer) {
		this.aeroportos.add(aer);
	}

	public Aeroporto buscarPorCodigo(String cod) {
		for (Aeroporto aer : aeroportos) {
			if (aer.getCodigo().equals(cod))
				return aer;
		}
		return null;
	}

	public Aeroporto buscarPorNome(String nome) {
		for (Aeroporto aer : aeroportos) {
			if (aer.getNome().contains(nome) && buscarPorCodigo(aer.getCodigo()) != null) {
				return aer;
			}
		}
		return null;
	}

	public String toString() {
		String gaer = "Aeroportos: ";
		for (Aeroporto aer : aeroportos)
			gaer += aer;
		return gaer;
	}

	public boolean readFile(String nomeArq) {
		Path path1 = Paths.get(nomeArq);
		try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
			String line = null;
			line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] dados = line.split(";");
				String cod = dados[0];
				double latitude = Double.parseDouble(dados[1]);
				double longitude = Double.parseDouble(dados[2]);
				String nome = dados[3];
				Aeroporto aer = new Aeroporto(cod, nome, new Geo(latitude, longitude));
				gaer.adicionar(aer);
			}
		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
		return true;
	}
}