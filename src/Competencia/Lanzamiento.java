package Competencia;

public class Lanzamiento {

	private double distancia;
	private double angulo;
	private boolean esValido;

	public Lanzamiento(double distancia, double angulo) {
		this.distancia = distancia;
		this.angulo = angulo;
		this.esValido = true;
	}

	public double distanciaEfectiva() {
		if (angulo >= -30 && angulo <= 30)
			return distancia;
		if ((angulo >= -90 && angulo < -30) || (angulo > 30 && angulo <= 90))
			return 0.8 * distancia;
		this.esValido = false;
		return 0;

	}

	public boolean getEsValido() {
		return esValido;
	}
}
