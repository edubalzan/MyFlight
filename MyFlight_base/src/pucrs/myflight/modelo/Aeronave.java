package pucrs.myflight.modelo;

public class Aeronave implements Contavel{
	private String codigo;
	private String descricao;
	private int totalObjects = 0;

	public Aeronave(String codigo, String descricao) {
		totalObjects += 1;
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String toString() {
		return "Total de objetos criados: " + totalObjects;
	}
}
