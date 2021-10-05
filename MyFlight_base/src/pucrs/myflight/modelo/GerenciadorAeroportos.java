package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeroportos {
	private ArrayList<Aeroporto> aeroportos;
	
	public GerenciadorAeroportos() {
		aeroportos = new ArrayList<>();
	}

	public void adicionar(Aeroporto aev) {
		aeroportos.add(aev);
	}

	public Aeroporto buscarPorCodigo(String cod) {
		for (int i = 0; i < aeroportos.size(); i++) {
			Aeroporto a = aeroportos.get(i);
			if(a.getCodigo().equals(cod))
				return a;
		}

		return null;
	}

	public ArrayList<Aeroporto> display() {
		return aeroportos;
	}

	public void ordenaNome() {
		Collections.sort(aeroportos);
	}
}