package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooDireto extends Voo {
    
    private Rota rota;
    private Duration duracao;

    // Construtor
    public VooDireto(Rota rota, LocalDateTime dh, Duration duracao, Status status) {
        super(dh);
        this.rota = rota;
        this.duracao = duracao;
    }

    public Rota getRota() {
        return rota;
    }

    public Duration getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return "\nRota: \n" + rota + "\nDuração: " + duracao;
    }
}