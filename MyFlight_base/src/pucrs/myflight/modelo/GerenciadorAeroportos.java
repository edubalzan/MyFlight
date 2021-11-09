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
		for (int i = 0; i < aeroportos.size(); i++) {
			Aeroporto a = aeroportos.get(i);
			if (a.getCodigo().equals(cod))
				return a;
		}

		return null;
	}

	public String toString() {
		for (Aeroporto aer : aeroportos)
			return "Aeroportos: " + aer;
		return null;
	}

	public void ordenaNome() {
		Collections.sort(aeroportos);
	}
}