package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooDireto extends Voo {
    private LocalDateTime datahora;

    public VooDireto(LocalDateTime datahora, Rota r) {
        super(r);
        this.datahora = datahora;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public Rota getRota() {
        return rota;
    }
}
