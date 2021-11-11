package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo {
    ArrayList<Rota> rotas = new ArrayList<Rota>();

    private Rota rota;
    private Duration duracao;
    private static int totalObjects = 0;

    // Construtor
    public VooEscalas(Rota rota, LocalDateTime dh, Duration duracao, Status status) {
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

    public void adicionarRota(Rota r) {
        rotas.add(r);
    }

    public static int totalObjects() {
        return totalObjects;
    }

    @Override
    public double calculaDuracao() {
        double duracaoEmMinutos = 0;
        for(Rota r : rotas) {
            Geo g1 = r.getOrigem().getLocal();
            Geo g2 = r.getDestino().getLocal();
            double speed = 805;
            double duracaoEmHoras = ((Geo.calculaDistancia(g1, g2)) / speed) + 0.5; // 30 minutos a mais para decolagem e aterrissagem
            duracaoEmMinutos = duracaoEmHoras * 60;
        }

        return duracaoEmMinutos;
	}

    @Override
    public String toString() {
        String rota = "Rotas: ";
        for(Rota r : rotas) {
            rota += r;
            return rota;
        }
        return "\nVoo com escala: " + "\nStatus: " + getStatus() + "\nData: " + getDatahora()
        + "\nDuração das rota: " + getDuracao()
        + "\nRotas: " + getRota();
    }
}