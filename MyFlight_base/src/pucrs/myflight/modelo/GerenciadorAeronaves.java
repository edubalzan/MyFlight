package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeronaves {
	private ArrayList<Aeronave> aeronaves;

	public GerenciadorAeronaves() {
		aeronaves = new ArrayList<Aeronave>();
	}

	public void adicionar(Aeronave aer) {
		aeronaves.add(aer);
	}

	public Aeronave buscarPorCodigo(String cod) {
		for (int i = 0; i < aeronaves.size(); i++) {
			Aeronave a = aeronaves.get(i);
			if (a.getCodigo().equals(cod))
				return a;
		}

		return null;
	}

	public String toString() {
		String aevs = "\nAeronaves: \n";
		for (Aeronave aev : aeronaves)
			aevs += aev + "\n";
		return aevs;
	}

	public void ordenaCodigo() {
		Collections.sort(aeronaves);
	}
}