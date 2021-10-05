package pucrs.myflight.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GerenciadorVoos {
	private ArrayList<Voo> empresas;
	
	public GerenciadorVoos() {
		empresas = new ArrayList<>();
	}

	public void adicionar(Voo v) {
		empresas.add(v);
	}

	public Voo buscarPorData(LocalDateTime datahora) {
		for (int i = 0; i < empresas.size(); i++) {
			Voo a = empresas.get(i);
			if(a.getDatahora().equals(datahora))
				return a;
		}

		return null;
	}

	public ArrayList<Voo> display() {
		return empresas;
	}
}
