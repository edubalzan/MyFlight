package pucrs.myflight.modelo;

public class Rota implements Comparable<Rota> {
	private CiaAerea cia;
	private Aeroporto origem;
	private Aeroporto destino;
	private Aeronave aeronave;
	private static int totalObjects = 0;

	public Rota(CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave) {
		totalObjects++;
		this.cia = cia;
		this.origem = origem;
		this.destino = destino;
		this.aeronave = aeronave;
	}

	public CiaAerea getCia() {
		return cia;
	}

	public Aeroporto getDestino() {
		return destino;
	}

	public Aeroporto getOrigem() {
		return origem;
	}

	public Aeronave getAeronave() {
		return aeronave;
	}

	public static int totalObjects() {
		return totalObjects;
	}

	public int compareTo(Rota r) {
		return cia.compareTo(r.getCia());
	}

	public String toString() {
		return "\nCompanhia aérea: " + cia.toString() + "\nOrigem: " + origem.toString()
		+ "\nDestino: " + destino.toString() + "\nAeronave: " + aeronave;
	}
}
