package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorRotas {
	private ArrayList<Rota> rotas;

	private static GerenciadorRotas gr = null;

	public GerenciadorRotas() {
		rotas = new ArrayList<Rota>();
	}

	public static GerenciadorRotas getInstance() {
        if (gr == null) {
           	gr = new GerenciadorRotas();
        }
        return gr;
    }

	public void adicionar(Rota r) {
		rotas.add(r);
	}

	public Rota buscarPorOrigem(Aeroporto orig) {
		for (int i = 0; i < rotas.size(); i++) {
			Rota a = rotas.get(i);
			if (a.getOrigem().equals(orig))
				return a;
		}

		return null;
	}

	public Rota buscarPorDestino(Aeroporto dest) {
		for (int i = 0; i < rotas.size(); i++) {
			Rota a = rotas.get(i);
			if (a.getDestino().equals(dest))
				return a;
		}
		return null;
	}

	public String toString() {
		String gr = "Rotas: ";
		for (Rota r : rotas)
			gr += r;
		return gr;
	}

	public void ordenaOrigem() {
		Collections.sort(rotas);
	}

	public boolean readFile(GerenciadorCias gcia, GerenciadorAeroportos gaer, GerenciadorAeronaves gaev) {
        Path path1 = Paths.get("routes.dat");
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
			line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(";");
               	CiaAerea cia = gcia.buscarPorCodigo(dados[0]);
				Aeroporto aerO = gaer.buscarPorCodigo(dados[1]);
				Aeroporto aerD = gaer.buscarPorCodigo(dados[2]);
				Aeronave aev = gaev.buscarPorCodigo(dados[4]);
                Rota r = new Rota(cia, aerO, aerD, aev);
                gr.adicionar(r);
            }
        }
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
        return true;
    }
}
