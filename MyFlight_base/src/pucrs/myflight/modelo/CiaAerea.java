package pucrs.myflight.modelo;

interface Contavel {
	public String toString();
}

public class CiaAerea {
	private String codigo;
	private String nome;
	private int totalObjects = 0;
	
	public CiaAerea(String codigo, String nome) {
		totalObjects += 1;
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public String toString() {
		return "Total de objetos criados: " + totalObjects;
	}
}
