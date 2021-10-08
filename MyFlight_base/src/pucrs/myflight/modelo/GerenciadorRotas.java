package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorRotas {
	private ArrayList<Rota> rotas;
	
	public GerenciadorRotas() {
		rotas = new ArrayList<Rota>();
	}

	public void adicionar(Rota r) {
		rotas.add(r);
	}

	public Rota buscarPorOrigem(Aeroporto orig) {
		for (int i = 0; i < rotas.size(); i++) {
			Rota a = rotas.get(i);
			if(a.getOrigem().equals(orig))
				return a;
		}

		return null;
	}

    public Rota buscarPorDestino(Aeroporto dest) {
		for (int i = 0; i < rotas.size(); i++) {
			Rota a = rotas.get(i);
			if(a.getDestino().equals(dest))
				return a;
		}

		return null;
	}

	public ArrayList<Rota> display() {
		return rotas;
	}

	public void ordenaOrigem() {
		Collections.sort(rotas);
	}

	public String toString() {
		String rs = "\nRotas: \n";
		for(Rota r : rotas)
			rs += r + "\n";
		return rs;
	}
}
