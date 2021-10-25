package pucrs.myflight.modelo;

public class Aeroporto implements Comparable<Aeroporto> {
	
	private String codigo;
	private String nome;
	private Geo loc;
	private static int totalObjects = 0;

	public Aeroporto(String codigo, String nome, Geo loc) {
		totalObjects++;
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

	public static int totalObjects() {
		return totalObjects;
	}

	public int compareTo(Aeroporto aer) {
		return nome.compareTo(aer.getNome());
	}

	public String toString() {
		return "\nCódigo: " + codigo + "\nNome: " + nome
		+ "\nLatidude: " + loc.getLatitude()
		+ "\nLongitude: " + loc.getLongitude();
	}
}
