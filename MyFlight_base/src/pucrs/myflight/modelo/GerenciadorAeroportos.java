package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeroportos {
	private ArrayList<Aeroporto> aeroportos;

	public GerenciadorAeroportos() {
		this.aeroportos = new ArrayList<Aeroporto>();
	}

	public void adicionar(Aeroporto aer) {
		this.aeroportos.add(aer);
	}

	public Aeroporto buscarPorCodigo(String cod) {
		for (Aeroporto aer : aeroportos) {
			if (aer.getCodigo().equals(cod))
				return aer;
		}
		return null;
	}

	public String toString() {
		String gaer = "Aeroportos: ";
		for (Aeroporto aer : aeroportos)
			gaer += aer;
		return gaer;
	}

	public void ordenaNome() {
		Collections.sort(aeroportos);
	}
}