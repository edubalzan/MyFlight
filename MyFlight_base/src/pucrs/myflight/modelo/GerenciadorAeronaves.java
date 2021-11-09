package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeronaves {
	private ArrayList<Aeronave> aeronaves;

	public GerenciadorAeronaves() {
		aeronaves = new ArrayList<Aeronave>();
	}

	public void adicionar(Aeronave aev) {
		aeronaves.add(aev);
	}

	public Aeronave buscarPorCodigo(String cod) {
		for (Aeronave aev : aeronaves) {
			if (aev.getCodigo().equals(cod))
				return aev;
		}
		return null;
	}

	public String toString() {
		for (Aeronave aev : aeronaves)
			return "Aeronaves: " + aev;
		return null;
	}

	public void ordenaCodigo() {
		Collections.sort(aeronaves);
	}
}