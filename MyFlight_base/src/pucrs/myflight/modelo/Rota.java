package pucrs.myflight.modelo;

public class Rota implements Contavel, Comparable<Rota> {
	private CiaAerea cia;
	private Aeroporto origem;
	private Aeroporto destino;
	private Aeronave aeronave;
	private int totalObjects = 0;

	public Rota(CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave) {
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

	public String totalObjects() {
		return "Total de objetos criados: " + totalObjects;
	}

	public int compareTo(Rota r) {
		return cia.compareTo(r.getCia());
	}
}
