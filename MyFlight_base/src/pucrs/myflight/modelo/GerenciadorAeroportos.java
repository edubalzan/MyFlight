package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeroportos {
	private ArrayList<Aeroporto> empresas;
	
	public GerenciadorAeroportos() {
		empresas = new ArrayList<>();
	}

	public void adicionar(Aeroporto aev) {
		empresas.add(aev);
	}

	public Aeroporto buscarPorCodigo(String cod) {
		for (int i = 0; i < empresas.size(); i++) {
			Aeroporto a = empresas.get(i);
			if(a.getCodigo().equals(cod))
				return a;
		}

		return null;
	}

	public ArrayList<Aeroporto> display() {
		return empresas;
	}
}