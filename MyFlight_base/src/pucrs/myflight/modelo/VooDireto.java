package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooDireto extends Voo {
    private Rota rota;
    private Duration duracao;
    private static int totalObjects = 0;

    // Construtor
    public VooDireto(Rota rota, LocalDateTime dh, Duration duracao, Status status) {
        super(dh, status);
        this.rota = rota;
        this.duracao = duracao;
        totalObjects++;
    }

    public Rota getRota() {
        return rota;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public static int totalObjects() {
		return totalObjects;
	}

    @Override
    public String toString() {
        return "\nVoo direto: " + "\nStatus: " + getStatus() + "\nData: " + getDatahora()
        + "\nDuração: " + getDuracao() + "\nRota: " + getRota();
    }

    @Override
    public double calculaDuracao() {
        Geo g1 = rota.getOrigem().getLocal();
        Geo g2 = rota.getDestino().getLocal();
		double speed = 805;
		double duracaoEmHoras = ((Geo.calculaDistancia(g1, g2)) / speed) + 0.5; // 30 minutos a mais para decolagem e aterrissagem
		double duracaoEmMinutos = duracaoEmHoras * 60;

		return duracaoEmMinutos;
	}
}