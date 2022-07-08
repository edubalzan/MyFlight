import java.util.Scanner;

import gerenciadores.*;
import objetos.*;

public class App {
	public static void main(String[] args) {
		// Entrada
		Scanner s = new Scanner(System.in);

		// Gerenciadores
		GerenciadorCias gcia = GerenciadorCias.getInstance();
		GerenciadorAeronaves gaev = GerenciadorAeronaves.getInstance();
		GerenciadorAeroportos gaer = GerenciadorAeroportos.getInstance();
		GerenciadorRotas gr = GerenciadorRotas.getInstance();

		// Leitura dos arquivos
		gcia.readFile("arquivos/airlines.dat");
		gaer.readFile("arquivos/airports.dat");
		gaev.readFile("arquivos/equipment.dat");
		gr.readFile(gcia, gaer, gaev);

		// Funcionamento da solicitação de um voo
		System.out.println("Digite o aeroporto de partida: ");
		String origem = s.nextLine();
		System.out.println("Digite o aeroporto de chegada: ");
		String destino = s.nextLine();
		Aeroporto aerOrigem = gaer.buscarPorNome(origem);
		Aeroporto aerDestino = gaer.buscarPorNome(destino);
		System.out.println("Escolha com qual companhia aérea você quer viajar: ");
		String cia = s.nextLine();
		CiaAerea ciaA = gcia.buscarPorNome(cia);
		System.out.println("Escolha em qual aeronave você quer viajar: ");
		String aeronave = s.nextLine();
		Aeronave aev = gaev.buscarPorCodigo(aeronave);
		Rota r = new Rota(ciaA, aerOrigem, aerDestino, aev);
		System.out.println("Confirmação das informações do seu voo: ");
		System.out.println(r.toString());
		System.out.println("Tenha uma ótima viagem!");
		s.close();
	}
}