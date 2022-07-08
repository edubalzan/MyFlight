package objetos;

public class Aeronave {
	private String codigo;
	private String descricao;
	private int capacidade;

	public Aeronave(String codigo, String descricao, int capacidade) {
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

	public String toString() {
		return "\nCódigo: " + codigo + "\nDescrição: " + descricao + "\n";
	}
}
