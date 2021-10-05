package pucrs.myflight.modelo;

public class Aeroporto implements Contavel, Comparable<Aeroporto> {
	private String codigo;
	private String nome;
	private Geo loc;
	private int totalObjects = 0;

	public Aeroporto(String codigo, String nome, Geo loc) {
		totalObjects += 1;
		this.codigo = codigo;
		this.nome = nome;
		this.loc = loc;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public Geo getLocal() {
		return loc;
	}

	public String totalObjects() {
		return "Total de objetos criados: " + totalObjects;
	}

	public int compareTo(Aeroporto aer) {
		return nome.compareTo(aer.getNome());
	}
}
