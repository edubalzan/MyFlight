package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo {
    ArrayList<Rota> rotas = new ArrayList<Rota>();

    private Rota rotaFinal;
    private static int totalObjects = 0;

    // Construtor
    public VooEscalas(Rota rota, Rota rotaFinal, LocalDateTime datahora, Duration duracao) {
        super(rota, datahora, duracao);
        this.rotaFinal = rotaFinal;
        totalObjects++;
    }

    public Rota getRotaFinal() {
        return rotaFinal;
    }

    public void adicionar(Rota r) {
        rotas.add(r);
    }

    public Rota getRota() {
        return rota;
    }

    public ArrayList<Rota> getRotas() {
        return rotas;
    }

    public static int totalObjects() {
        return totalObjects;
    }

    @Override
    public String toString() {
        return super.toString() + " -> " + rotaFinal;
    }
}