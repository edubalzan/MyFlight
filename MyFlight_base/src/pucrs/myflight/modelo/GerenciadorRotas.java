package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorRotas {
	private ArrayList<Rota> empresas;
	
	public GerenciadorRotas() {
		empresas = new ArrayList<>();
	}

	public void adicionar(Rota r) {
		empresas.add(r);
	}

	public Rota buscarPorOrigem(Aeroporto orig) {
		for (int i = 0; i < empresas.size(); i++) {
			Rota a = empresas.get(i);
			if(a.getOrigem().equals(orig))
				return a;
		}

		return null;
	}

    public Rota buscarPorDestino(Aeroporto dest) {
		for (int i = 0; i < empresas.size(); i++) {
			Rota a = empresas.get(i);
			if(a.getDestino().equals(dest))
				return a;
		}

		return null;
	}

	public ArrayList<Rota> display() {
		return empresas;
	}
}
