package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Voo implements Comparable<Voo> {

	public enum Status {
		CONFIRMADO, ATRASADO, CANCELADO
	};

	private LocalDateTime dh;
	private static int totalObjects = 0;

	public Voo(LocalDateTime dh) {
		this.dh = dh;
	}

	public abstract Rota getRota();
	public abstract Duration getDuracao();

	public LocalDateTime getDatahora() {
		return dh;
	}

	public static int totalObjects() {
		return totalObjects;
	}

	public int compareTo(Voo v) {
		return dh.compareTo(v.getDatahora());
	}

	public static double calculaDuracao(Voo v, Geo g1, Geo g2) {
		double speed = 805;
		double duracaoEmHoras = (Geo.calculaDistancia(g1, g2) / speed) + 0.5; //30 minutos a mais para decolagem e aterrissagem
		double duracaoEmMinutos = duracaoEmHoras * 60;

		return duracaoEmMinutos;
	}
}
