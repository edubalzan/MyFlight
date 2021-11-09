package pucrs.myflight.modelo;

public class Aeronave implements Comparable<Aeronave> {
	private String codigo;
	private String descricao;
	private int capacidade;
	private static int totalObjects = 0;

	public Aeronave(String codigo, String descricao, int capacidade) {
		totalObjects++;
		this.codigo = codigo;
		this.descricao = descricao;
		this.capacidade = capacidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public static int totalObjects() {
		return totalObjects;
	}

	public int compareTo(Aeronave aer) {
		return codigo.compareTo(aer.getCodigo());
	}

	public String toString() {
		return "\nCódigo: " + codigo + "\nDescrição: " + descricao + "\n";
	}
}
