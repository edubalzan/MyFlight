package pucrs.myflight.modelo;

public class Aeronave implements Comparable<Aeronave> {
	private String codigo;
	private String descricao;
	private static int totalObjects = 0;

	public Aeronave(String codigo, String descricao) {
		totalObjects++;
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static int totalObjects() {
		return totalObjects;
	}

	public int compareTo(Aeronave aer) {
		return codigo.compareTo(aer.getCodigo());
	}

	public String toString() {
		return "\nCódigo: " + codigo + "\nDescrição: " + descricao;
	}
}
