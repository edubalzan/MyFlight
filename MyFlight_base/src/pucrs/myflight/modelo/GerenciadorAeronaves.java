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
		String gaev = "Aeronaves: ";
		for (Aeronave aev : aeronaves)
			gaev += aev;
		return gaev;
	}

	public void ordenaCodigo() {
		Collections.sort(aeronaves);
	}
}