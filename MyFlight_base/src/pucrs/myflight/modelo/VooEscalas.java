package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo {
    ArrayList<Rota> rotas = new ArrayList<Rota>();

    private Rota rotaI;
    private Rota rotaF;
    private Duration duracao;

    // Construtor
    public VooEscalas(Rota rotaI, Rota rotaF, LocalDateTime dh, Duration duracao, Status status) {
        super(dh);
        this.rotaI = rotaI;
        this.rotaF = rotaF;
        this.duracao = duracao;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public Rota getRota() {
        return rotaI;
    }

    public void adicionar(Rota rI, Rota rF) {
        rotas.add(rI);
        rotas.add(rF);
    }

    @Override
    public String toString() {
        return "\n" + rotaI + " -> " + rotaF;
    }
}