package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorCias {
	private ArrayList<CiaAerea> cias;

	private static GerenciadorCias gcia = null;

	private GerenciadorCias() {
		cias = new ArrayList<CiaAerea>();
	}

	public static GerenciadorCias getInstance() {
        if (gcia == null) {
           	gcia = new GerenciadorCias();
        }
        return gcia;
    }

	public void adicionar(CiaAerea cia) {
		cias.add(cia);
	}

	public CiaAerea buscarPorCodigo(String cod) {
		for (CiaAerea cia : cias) {
			if (cia.getCodigo().equals(cod))
				return cia;
		}
		return null;
	}

	public CiaAerea buscarPorNome(String nome) {
		for (CiaAerea cia : cias) {
			if (cia.getNome().equals(nome))
				return cia;
		}
		return null;
	}

	public String toString() {
		String gcia = "Companhias aéreas: ";
		for (CiaAerea cia : cias)
			gcia += cia;
		return gcia;
	}

	public void ordenaNome() {
		Collections.sort(cias);
	}

	public boolean readFile(String nomeArq) {
        Path path1 = Paths.get(nomeArq);
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
			line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(";");
                String cod = dados[0];
				String nome = dados[1];
                CiaAerea cia = new CiaAerea(cod, nome);
                gcia.adicionar(cia);
            }
        }
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
        return true;
    }
}
