package pucrs.myflight.modelo;

public class CiaAerea implements Comparable<CiaAerea> {
	private String codigo;
	private String nome;
	private static int totalObjects = 0;

	public CiaAerea(String codigo, String nome) {
		totalObjects++;
		this.codigo = codigo;
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public static int totalObjects() {
		return totalObjects;
	}

	public int compareTo(CiaAerea cia) {
		return nome.compareTo(cia.getNome());
	}

	public String toString() {
		return "\nCódigo: " + codigo + "\nNome: " + nome;
	}
}
