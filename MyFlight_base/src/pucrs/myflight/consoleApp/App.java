package pucrs.myflight.consoleApp;

import pucrs.myflight.modelo.Aeronave;
import pucrs.myflight.modelo.Aeroporto;
import pucrs.myflight.modelo.CiaAerea;
import pucrs.myflight.modelo.Geo;
import pucrs.myflight.modelo.GerenciadorAeronaves;
import pucrs.myflight.modelo.GerenciadorAeroportos;
import pucrs.myflight.modelo.GerenciadorCias;
import pucrs.myflight.modelo.GerenciadorRotas;
import pucrs.myflight.modelo.GerenciadorVoos;
import pucrs.myflight.modelo.Rota;
import pucrs.myflight.modelo.Voo;
import pucrs.myflight.modelo.VooDireto;
import pucrs.myflight.modelo.VooEscalas;
import pucrs.myflight.modelo.Voo.Status;

import java.time.LocalDateTime;
import java.time.Duration;

public class App {
	public static void main(String[] args) {
		// Gerenciadores
		GerenciadorCias gcia = new GerenciadorCias();
		GerenciadorAeronaves gaev = new GerenciadorAeronaves();
		GerenciadorAeroportos gaer = new GerenciadorAeroportos();
		GerenciadorRotas gr = new GerenciadorRotas();
		GerenciadorVoos gv = new GerenciadorVoos();

		// Objetos
		CiaAerea cia1 = new CiaAerea("AD", "Azul");
		Aeronave aev1 = new Aeronave("001", "A380", 250);
		Aeronave aev2 = new Aeronave("002", "A320", 130);
		Geo g1 = new Geo(-29.993528934213817, -51.175284542239574); //Salgado Filho
		Geo g2 = new Geo(-23.43049433141058, -46.473075188409055); //Guarulhos
		Geo g3 = new Geo(-22.91095601861328, -43.16448926380469); //Santos Dumont
		Aeroporto aer1 = new Aeroporto("123", "Salgado Filho", g1);
		Aeroporto aer2 = new Aeroporto("456", "Guarulhos", g2);
		Aeroporto aer3 = new Aeroporto("789", "Santos Dumount", g3);
		Rota r1 = new Rota(cia1, aer1, aer2, aev2);
		Rota r2 = new Rota(cia1, aer2, aer3, aev1);
		LocalDateTime dh1 = LocalDateTime.of(2016, 8, 12, 12, 0);
		Duration duracao1 = Duration.ofMinutes(120);
		Duration duracao2 = Duration.ofMinutes(100);
		VooDireto vd1 = new VooDireto(r1, dh1, duracao1, Status.CONFIRMADO);
		VooEscalas ve1 = new VooEscalas(r1, r2, dh1, duracao1, duracao2, Status.CONFIRMADO);

		// Adicionando os objetos aos gerenciadores
		gcia.adicionar(cia1);
		gaev.adicionar(aev1);
		gaev.adicionar(aev2);
		gaer.adicionar(aer1);
		gaer.adicionar(aer2);
		gaer.adicionar(aer3);
		gr.adicionar(r1);
		gr.adicionar(r2);
		gv.adicionar(vd1);
		gv.adicionar(ve1);

		// Total de cada objeto
		System.out.println("Total de aeroportos: " + Aeroporto.totalObjects());
		System.out.println("Total de aeronaves: " + Aeronave.totalObjects());
		System.out.println("Total de companhias aéreas: " + CiaAerea.totalObjects());
		System.out.println("Total de rotas: " + Rota.totalObjects());
		System.out.println("Total de voos diretos: " + VooDireto.totalObjects());
		System.out.println("Total de voos com escala: " + VooEscalas.totalObjects());
		System.out.println("Total de geos (cordenadas): " + Geo.totalObjects());

		System.out.println("\n");

		// Lista de cada tipo de objeto
		System.out.println(gaer.toString()); // Aeroportos
		System.out.println(gcia.toString()); // Companhias aéreas
		System.out.println(gv.toString()); // Voos
		System.out.println(gaev.toString()); // Aeronaves
		System.out.println(gr.toString()); // Rotas

		// Distância entre aeroporto Salgado Filho e Guarulhos
		System.out.printf("\nA distância é de aproximadamente %.2f km\n", Geo.calculaDistancia(g1, g2));
		// Duração do voo de Salgado Filho a Guarulhos
		System.out.printf("Duração do voo: %.2f minutos", Voo.calculaDuracao(vd1, g1, g2));
	}
}