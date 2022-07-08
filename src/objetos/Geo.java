package objetos;

public class Geo {
	private double latitude;
	private double longitude;
	private static final double raio = 6371;

	public Geo(double latitude, double longitude) {
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
}
