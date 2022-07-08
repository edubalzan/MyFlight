package objetos;

public class CiaAerea {
	private String codigo;
	private String nome;

	public CiaAerea(String codigo, String nome) {
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
		return "\nCódigo: " + codigo + "\nNome: " + nome + "\n";
	}
}
