package pucrs.myflight.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorVoos {
	private ArrayList<Voo> voos;

	public GerenciadorVoos() {
		voos = new ArrayList<Voo>();
	}

	public void adicionar(Voo v) {
		voos.add(v);
	}

	public Voo buscarPorData(LocalDateTime datahora) {
		for (int i = 0; i < voos.size(); i++) {
			Voo a = voos.get(i);
			if (a.getDatahora().equals(datahora))
				return a;
		}

		return null;
	}

	public String toString() {
		for (Voo v : voos)
			return "Voos: " + v;
		return null;
	}

	public void ordenaData() {
		Collections.sort(voos);
	}
}
