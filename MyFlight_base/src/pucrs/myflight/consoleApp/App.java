package pucrs.myflight.consoleApp;

import pucrs.myflight.modelo.*;
import pucrs.myflight.modelo.Voo.Status;

import java.time.LocalDateTime;
import java.time.Duration;

public class App {
	public static void main(String[] args) {
		// Gerenciadores
		GerenciadorCias gcia = GerenciadorCias.getInstance();
		GerenciadorAeronaves gaev = GerenciadorAeronaves.getInstance();
		GerenciadorAeroportos gaer = GerenciadorAeroportos.getInstance();
		GerenciadorRotas gr = GerenciadorRotas.getInstance();
		GerenciadorVoos gv = new GerenciadorVoos();

		// Objetos
		CiaAerea cia1 = new CiaAerea("AD", "Azul");
		CiaAerea cia2 = new CiaAerea("G", "Gol");
		Aeronave aev1 = new Aeronave("001", "A380", 300);
		Aeronave aev2 = new Aeronave("003", "A320", 130);
		Aeronave aev3 = new Aeronave("002", "A360", 200);
		Geo g1 = new Geo(-30, -51); // Salgado Filho
		Geo g2 = new Geo(-23, -46); // Guarulhos
		Geo g3 = new Geo(-23, -43); // Santos Dumont
		Aeroporto aer1 = new Aeroporto("123", "Salgado Filho", g1);
		Aeroporto aer2 = new Aeroporto("456", "Guarulhos", g2);
		Aeroporto aer3 = new Aeroporto("789", "Santos Dumount", g3);
		Rota r1 = new Rota(cia1, aer1, aer2, aev2);
		Rota r2 = new Rota(cia1, aer2, aer3, aev1);
		Rota r3 = new Rota(cia2, aer3, aer2, aev3);
		LocalDateTime dh1 = LocalDateTime.of(2016, 8, 12, 12, 0);
		Duration duracao1 = Duration.ofMinutes(120);
		Duration duracao2 = Duration.ofMinutes(100);
		VooDireto vd1 = new VooDireto(r1, dh1, duracao1, Status.CONFIRMADO);
		VooDireto vd2 = new VooDireto(r3, dh1, duracao1, Status.CONFIRMADO);
		VooEscalas ve1 = new VooEscalas(r1, dh1, duracao1, Status.CONFIRMADO);
		ve1.adicionarRota(r3);

		// Adicionando os objetos aos gerenciadores
		gcia.adicionar(cia1);
		gaev.adicionar(aev1);
		gaev.adicionar(aev2);
		gaev.adicionar(aev3);
		gaer.adicionar(aer1);
		gaer.adicionar(aer2);
		gaer.adicionar(aer3);
		gr.adicionar(r1);
		gr.adicionar(r2);
		gv.adicionar(vd1);
		gv.adicionar(vd2);
		gv.adicionar(ve1);

		gcia.readFile("airlines.dat");
		gaer.readFile("airports.dat");
		gaev.readFile("equipment.dat");
		gr.readFile(gcia, gaer, gaev);
		
		// Total de cada objeto
		System.out.println("Total de aeroportos: " + Aeroporto.totalObjects());
		System.out.println("Total de aeronaves: " + Aeronave.totalObjects());
		System.out.println("Total de companhias aéreas: " + CiaAerea.totalObjects());
		System.out.println("Total de rotas: " + Rota.totalObjects());
		System.out.println("Total de voos diretos: " + VooDireto.totalObjects());
		System.out.println("Total de voos com escala: " + VooEscalas.totalObjects());
		System.out.println("Total de geos (cordenadas): " + Geo.totalObjects());

		// Métodos de ordenação
		gv.ordenaData();
		gaev.ordenaCodigo();
		gcia.ordenaNome();
		gr.ordenaOrigem();
		gaer.ordenaNome();

		// Lista de cada tipo de objeto
		System.out.println(gaer.toString()); // Aeroportos
		System.out.println(gaev.toString()); // Aeronaves
		System.out.println(gcia.toString()); // Companhias aéreas
		System.out.println(gv.toString()); // Voos

		// Métodos de busca dos objetos criados
		System.out.println(gaer.buscarPorCodigo("123"));
		System.out.println(gaev.buscarPorCodigo("001"));
		System.out.println(gv.buscarPorData(LocalDateTime.of(2016, 8, 12, 12, 0)));
		System.out.println(gcia.buscarPorCodigo("ZM"));
		System.out.println(gcia.buscarPorNome("ExecAir"));

		// Distância entre aeroporto Salgado Filho e Guarulhos
		System.out.printf("\nA distância é de aproximadamente %.2f km\n", Geo.calculaDistancia(g1, g2));
		// Duração do voo de Salgado Filho a Guarulhos
		System.out.printf("Duração do voo: %.2f minutos\n", vd1.calculaDuracao());
	}
}