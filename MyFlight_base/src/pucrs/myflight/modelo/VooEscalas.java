package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo {
    ArrayList<Rota> rotas = new ArrayList<Rota>();

    private Rota rotaI;
    private Rota rotaF;
    private Duration duracaoRotaI;
    private Duration duracaoRotaF;

    // Construtor
    public VooEscalas(Rota rotaI, Rota rotaF, LocalDateTime dh, Duration duracaoRotaI, Duration duracaoRotaF, Status status) {
        super(dh, status);
        this.rotaI = rotaI;
        this.rotaF = rotaF;
        this.duracaoRotaI = duracaoRotaI;
        this.duracaoRotaF = duracaoRotaF;
    }

    public Rota getRotaI() {
        return rotaI;
    }

    public Rota getRotaF() {
        return rotaF;
    }

    public Duration getDuracaoRotaI() {
        return duracaoRotaI;
    }

    public Duration getDuracaoRotaF() {
        return duracaoRotaF;
    }

    public void adicionar(Rota rI, Rota rF) {
        rotas.add(rI);
        rotas.add(rF);
    }

    @Override
    public String toString() {
        return "\nVoo com escala: " + "\nStatus: " + getStatus() + "\nData: " + getDatahora()
        + "\nDuração das rota: " + getDuracaoRotaI() + "-->" + getDuracaoRotaF()
        + "\nRotas: " + getRotaI() + "-->" + getRotaF();
    }
}