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
		for (Voo v : voos) {
			if (v.getDatahora().equals(datahora))
				return v;
		}
		return null;
	}

	public String toString() {
		String gv = "Voos: ";
		for (Voo v : voos)
			gv += v;
		return gv;
	}

	public void ordenaData() {
		Collections.sort(voos);
	}
}
