package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() {
		empresas = new ArrayList<CiaAerea>();
	}

	public void adicionar(CiaAerea cia) {
		empresas.add(cia);
	}

	public CiaAerea buscarPorCodigo(String cod) {
		for (int i = 0; i < empresas.size(); i++) {
			CiaAerea a = empresas.get(i);
			if(a.getCodigo().equals(cod))
				return a;
		}

		return null;
	}

	public CiaAerea buscarPorNome(String nome) {
		for (int i = 0; i < empresas.size(); i++) {
			CiaAerea a = empresas.get(i);
			if(a.getNome().equalsIgnoreCase(nome))
				return a;
		}

		return null;
	}

	public ArrayList<CiaAerea> display() {
		return empresas;
	}

	public String toString() {
		String cias = "\nCompanhias aéreas: \n";
		for(CiaAerea cia : empresas)
			cias += cia + "\n";
		return cias;
	}

	public void ordenaNome() {
		Collections.sort(empresas);
	}
}
