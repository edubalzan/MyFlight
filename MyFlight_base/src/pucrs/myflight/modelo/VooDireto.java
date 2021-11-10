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

    public Rota getRotaI() {
        return rota;
    }

    public Duration getDuracaoRotaI() {
        return duracao;
    }

    public Duration getDuracaoRotaF() {
        return null;
    }

    public static int totalObjects() {
		return totalObjects;
	}

    @Override
    public String toString() {
        return "\nVoo direto: " + "\nStatus: " + getStatus() + "\nData: " + getDatahora()
        + "\nDuração: " + getDuracaoRotaI() + "\nRota: " + getRotaI();
    }
}