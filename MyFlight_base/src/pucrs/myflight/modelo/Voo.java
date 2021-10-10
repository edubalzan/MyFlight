package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Voo implements Comparable<Voo> {

	public enum Status {
		CONFIRMADO, ATRASADO, CANCELADO
	};

	private LocalDateTime datahora;
	private Duration duracao;
	private Rota rota;
	private Status status;
	private static int totalObjects = 0;

	public Voo(Rota rota, LocalDateTime datahora, Duration duracao) {
		totalObjects += 1;
		this.rota = rota;
		this.datahora = datahora;
		this.duracao = duracao;
		this.status = Status.CONFIRMADO; // default é confirmado
	}

	public Voo(Rota rota) {
		this.rota = rota;
	}

	public Rota getRota() {
		return rota;
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}

	public Duration getDuracao() {
		return duracao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status novo) {
		this.status = novo;
	}

	public static int totalObjects() {
		return totalObjects;
	}

	public int compareTo(Voo v) {
		return datahora.compareTo(v.getDatahora());
	}

	public static double calculaDuracao(Voo v, Geo g1, Geo g2) {
		double speed = 805;
		double duracaoEmHoras = (Geo.calculaDistancia(g1, g2) / speed) + 0.5; //30 minutos a mais para decolagem e aterrissagem
		double duracaoEmMinutos = duracaoEmHoras * 60;

		return duracaoEmMinutos;
	}

	public String toString() {
		return "\nRota(s): " + rota + "\nHora local: " + datahora
		+ "\nDuração: " + duracao; 
	}
}
