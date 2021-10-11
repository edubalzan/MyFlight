package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorRotas {
	private ArrayList<Rota> origens;
	
	public GerenciadorRotas() {
		origens = new ArrayList<Rota>();
	}

	public void adicionar(Rota r) {
		origens.add(r);
	}

	public Rota buscarPorOrigem(Aeroporto orig) {
		for (int i = 0; i < origens.size(); i++) {
			Rota a = origens.get(i);
			if(a.getOrigem().equals(orig))
				return a;
		}

		return null;
	}

    public Rota buscarPorDestino(Aeroporto dest) {
		for (int i = 0; i < origens.size(); i++) {
			Rota a = origens.get(i);
			if(a.getDestino().equals(dest))
				return a;
		}

		return null;
	}

	public String toString() {
		String rs = "\norigens: \n";
		for(Rota r : origens)
			rs += r + "\n";
		return rs;
	}

	public void ordenaOrigem() {
		Collections.sort(origens);
	}
}
