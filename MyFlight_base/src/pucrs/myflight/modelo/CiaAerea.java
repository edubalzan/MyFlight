package pucrs.myflight.modelo;

interface Contavel {
	public String totalObjects();
}

public class CiaAerea implements Contavel, Comparable<CiaAerea> {
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

	public String totalObjects() {
		return "Total de objetos criados: " + totalObjects;
	}

	public int compareTo(CiaAerea cia) {
		return nome.compareTo(cia.getNome());
	}
}
