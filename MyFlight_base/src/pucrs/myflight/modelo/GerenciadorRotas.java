package pucrs.myflight.modelo;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.nio.charset.Charset;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorRotas {
	private ArrayList<Rota> rotas;

	// private static GerenciadorRotas gr = null;

	public GerenciadorRotas() {
		rotas = new ArrayList<Rota>();
	}

	// public static GerenciadorRotas getInstance() {
    //     if (gr == null) {
    //        	gr = new GerenciadorRotas();
    //     }
    //     return gr;
    // }

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

	// public boolean readFile(String nomeArq) {
    //     Path path1 = Paths.get(nomeArq);
    //     try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
    //         String line = null;
	// 		line = reader.readLine();
    //         while ((line = reader.readLine()) != null) {
    //             String[] dados = line.split(";");
    //             String codCia = dados[0];
	// 			String nomeCia = dados[1];
	// 			String codAerOrig = dados[2];
	// 			String nomeAerOrig = dados[3];
	// 			double latitudeOrig = Double.parseDouble(dados[4]);
	// 			double longitudeOrig = Double.parseDouble(dados[5]);
	// 			String codAerDest = dados[6];
	// 			String nomeAerDest = dados[7];
	// 			double latitudeDest = Double.parseDouble(dados[8]);
	// 			double longitudeDest = Double.parseDouble(dados[9]);
	// 			String codAev = dados[10];
	// 			String descricaoAev = dados[11];
	// 			int capacidadeAev = Integer.parseInt(dados[12]);
    //             Rota r = new Rota(new CiaAerea(codCia, nomeCia), new Aeroporto(codAerOrig, nomeAerOrig,
	// 			new Geo(latitudeOrig, longitudeOrig)), new Aeroporto(codAerDest, nomeAerDest,
	// 			new Geo(latitudeDest, longitudeDest)), new Aeronave(codAev, descricaoAev, capacidadeAev));
    //             gr.adicionar(r);
    //         }
    //     }
    //     catch (IOException x) {
    //         System.err.format("Erro de E/S: %s%n", x);
    //     }
    //     return true;
    // }
}
