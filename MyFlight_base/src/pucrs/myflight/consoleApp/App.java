package pucrs.myflight.consoleApp;

import pucrs.myflight.modelo.Aeronave;
import pucrs.myflight.modelo.Aeroporto;
import pucrs.myflight.modelo.CiaAerea;
import pucrs.myflight.modelo.Geo;
import pucrs.myflight.modelo.Rota;
import pucrs.myflight.modelo.Voo;

import java.time.LocalDateTime;
import java.time.Duration;

public class App {
	public static void main(String[] args) {
		// 1º voo com dois tipos de criação de voo
		CiaAerea cia1 = new CiaAerea("01", "Azul");
		Aeronave aer1 = new Aeronave("001", "A380");
		Geo g1 = new Geo(-29.99, -51.17);
		Geo g2 = new Geo(-23.43, -46.47);
		Aeroporto orig1 = new Aeroporto("123", "Salgado Filho", g1);
		Aeroporto dest1 = new Aeroporto("456", "Guarulhos", g2);
		Rota r1 = new Rota(cia1, orig1, dest1, aer1);
		LocalDateTime horaLocal1 = LocalDateTime.of(2016, 8, 12, 12, 0);
		Duration duracao = Duration.ofMinutes(120);
		Voo v1a = new Voo(r1, horaLocal1, duracao);
		Voo v1b = new Voo(r1);

		System.out.printf("A distância é de aproximadamente %f km", Geo.calculaDistancia(g1, g2));
	}
}