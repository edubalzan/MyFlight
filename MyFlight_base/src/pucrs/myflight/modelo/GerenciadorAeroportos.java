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
			if(a.getCodigo().equals(cod))
				return a;
		}

		return null;
	}

	public ArrayList<Aeroporto> listarTodos() {
        return aeroportos;
    }

	public String toString() {
		String aeros = "\nAeroportos: \n";
		for(Aeroporto aer : aeroportos) {
			aeros += aer + "\n";
		}
		return aeros;
	}

	public void ordenaNome() {
		Collections.sort(aeroportos);
	}
}