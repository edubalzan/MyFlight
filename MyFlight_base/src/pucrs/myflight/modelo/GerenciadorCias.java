package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorCias {
	private ArrayList<CiaAerea> cias;
	
	public GerenciadorCias() {
		cias = new ArrayList<CiaAerea>();
	}

	public void adicionar(CiaAerea cia) {
		cias.add(cia);
	}

	public CiaAerea buscarPorCodigo(String cod) {
		for (int i = 0; i < cias.size(); i++) {
			CiaAerea a = cias.get(i);
			if(a.getCodigo().equals(cod))
				return a;
		}

		return null;
	}

	public CiaAerea buscarPorNome(String nome) {
		for (int i = 0; i < cias.size(); i++) {
			CiaAerea a = cias.get(i);
			if(a.getNome().equalsIgnoreCase(nome))
				return a;
		}

		return null;
	}

	public String toString() {
		String cias2 = "\nCompanhias aéreas: \n";
		for(CiaAerea cia : cias)
			cias2 += cia + "\n";
		return cias2;
	}

	public void ordenaNome() {
		Collections.sort(cias);
	}
}
