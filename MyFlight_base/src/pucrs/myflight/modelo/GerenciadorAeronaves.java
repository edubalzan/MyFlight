package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeronaves {
	private ArrayList<Aeronave> empresas;
	
	public GerenciadorAeronaves() {
		empresas = new ArrayList<>();
	}

	public void adicionar(Aeronave aer) {
		empresas.add(aer);
	}

	public Aeronave buscarPorCodigo(String cod) {
		for (int i = 0; i < empresas.size(); i++) {
			Aeronave a = empresas.get(i);
			if(a.getCodigo().equals(cod))
				return a;
		}

		return null;
	}

	public ArrayList<Aeronave> display() {
		return empresas;
	}
}