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
			if (a.getCodigo().equals(cod))
				return a;
		}

		return null;
	}

	public CiaAerea buscarPorNome(String nome) {
		for (CiaAerea cia : cias) {
			if (cia.getCodigo().equals(nome))
				return cia;
		}
		return null;
	}

	public String toString() {
		String gcia = "Companhias aéreas: ";
		for (CiaAerea cia : cias)
			gcia += cia;
		return gcia;
	}

	public void ordenaNome() {
		Collections.sort(cias);
	}
}
