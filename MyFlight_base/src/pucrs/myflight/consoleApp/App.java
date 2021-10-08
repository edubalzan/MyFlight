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
import pucrs.myflight.modelo.VooEscalas;

import java.time.LocalDateTime;
import java.time.Duration;

public class App {
	public static void main(String[] args) {		
		//Gerenciadores
		GerenciadorCias gcia = new GerenciadorCias();
		GerenciadorAeronaves gaev = new GerenciadorAeronaves();
		GerenciadorAeroportos gaer = new GerenciadorAeroportos();
		GerenciadorRotas gr = new GerenciadorRotas();
		GerenciadorVoos gv = new GerenciadorVoos();
		
		// Objetos
		CiaAerea cia1 = new CiaAerea("AD", "Azul");
		Aeronave aev1 = new Aeronave("001", "A380");
		Aeronave aev2 = new Aeronave("002", "A320");
		Geo g1 = new Geo(-29.99, -51.17);
		Geo g2 = new Geo(-23.43, -46.47);
		Geo g3 = new Geo(-22.86, -43.17);
		Aeroporto aer1 = new Aeroporto("123", "Salgado Filho", g1);
		Aeroporto aer2 = new Aeroporto("456", "Guarulhos", g2);
		Aeroporto aer3 = new Aeroporto("789", "Santos Dumount", g3);
		Rota r1 = new Rota(cia1, aer1, aer2, aev1);
		Rota r2 = new Rota(cia1, aer2, aer3, aev2);
		LocalDateTime horaLocal1 = LocalDateTime.of(2016, 8, 12, 12, 0);
		Duration duracao = Duration.ofMinutes(120);
		Voo v1a = new Voo(r1, horaLocal1, duracao);
		// Voo v1b = new Voo(r1);
		VooEscalas ve1 = new VooEscalas(r1, r2, horaLocal1, duracao);

		//Adicionando os objetos aos gerenciadores
		gcia.adicionar(cia1);
		gaev.adicionar(aev1);
		gaev.adicionar(aev2);
		gaer.adicionar(aer1);
		gaer.adicionar(aer2);
		gaer.adicionar(aer3);
		gr.adicionar(r1);
		gr.adicionar(r2);
		gv.adicionar(v1a);
		gv.adicionar(ve1);

		//Total de cada objeto
		System.out.println("Total de aeroportos: " + Aeroporto.totalObjects());
		System.out.println("Total de aeronaves: " + Aeronave.totalObjects());
		System.out.println("Total de companhias aéreas: " + CiaAerea.totalObjects());
		System.out.println("Total de rotas: " + Rota.totalObjects());
		System.out.println("Total de voos: " + Voo.totalObjects());
		System.out.println("Total de voos com escala: " + VooEscalas.totalObjects());

		//Lista de cada tipo de objeto
		System.out.println(gaer.toString()); //Aeroportos
		System.out.println(gcia.toString()); //Companhias aéreas
		System.out.println(gv.toString()); //Voos
		System.out.println(gaev.toString()); //Aeronaves
		System.out.println(gr.toString()); //Rotas

		//Distância entre aeroporto Salgado Filho e Guarulhos
		System.out.printf("\nA distância é de aproximadamente %.2f km\n", Geo.calculaDistancia(g1, g2));
		//Duração do voo de Salgado Filho a Guarulhos
		System.out.printf("Duração do voo: %.2f minutos", Voo.calculaDuracao(v1a, g1, g2));
	}
}