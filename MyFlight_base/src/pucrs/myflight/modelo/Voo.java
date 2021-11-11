package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Voo implements Comparable<Voo> {
	public enum Status {
		CONFIRMADO, ATRASADO, CANCELADO
	};

	private LocalDateTime dh;
	private Status status;
	private static int totalObjects = 0;

	public Voo(LocalDateTime dh, Status status) {
		this.dh = dh;
		this.status = status;
	}

	public abstract Rota getRota();
	public abstract Duration getDuracao();

	public Status getStatus() {
		return status;
	}

	public LocalDateTime getDatahora() {
		return dh;
	}

	public static int totalObjects() {
		return totalObjects;
	}

	public int compareTo(Voo v) {
		return dh.compareTo(v.getDatahora());
	}

	public abstract double calculaDuracao();
}
