package pucrs.myflight.modelo;

public class Geo {
	private double latitude;
	private double longitude;
	private static final double raio = 6371.00;
	private static double distancia;
	private static int totalObjects = 0;

	public Geo(double latitude, double longitude) {
		totalObjects++;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getRaio() {
		return raio;
	}

	public static double calculaDistancia(Geo g1, Geo g2) {
		Math.toRadians(g1.getLatitude());
		Math.toRadians(g2.getLatitude());
		Math.toRadians(g1.getLongitude());
		Math.toRadians(g2.getLongitude());

		distancia = 2 * raio
				* Math.asin(Math.sqrt(Math.pow(Math.sin((g1.getLatitude() - g2.getLatitude()) / 2), 2)
						+ (Math.pow(Math.sin((g1.getLongitude() - g2.getLongitude()) / 2), 2)
								* (Math.cos(g1.getLatitude())) * (Math.cos(g2.getLatitude())))));

		return distancia;
	}

	public static int totalObjects() {
		return totalObjects;
	}
}
