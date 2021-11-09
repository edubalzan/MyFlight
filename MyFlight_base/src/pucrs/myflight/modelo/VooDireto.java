package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooDireto extends Voo {
    private Rota rota;
    private Duration duracao;

    // Construtor
    public VooDireto(Rota rota, LocalDateTime dh, Duration duracao, Status status) {
        super(dh, status);
        this.rota = rota;
        this.duracao = duracao;
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

    @Override
    public String toString() {
        return "\nVoo direto: " + "\nStatus: " + getStatus() + "\nData: " + getDatahora()
        + "\nDuração: " + getDuracaoRotaI() + "\nRota: " + getRotaI();
    }
}