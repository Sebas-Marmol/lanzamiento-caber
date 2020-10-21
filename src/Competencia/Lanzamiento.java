package Competencia;

public class Lanzamiento {

	private double distancia;
	private double angulo;
	private boolean esValido;
	private double distanciaEfectiva;

	public Lanzamiento(double distancia, double angulo) {
		this.distancia = distancia;
		this.angulo = angulo;
		this.esValido = true;
	}

	public double distanciaEfectiva() {
		if (angulo >= -30 && angulo <= 30)
			distanciaEfectiva = distancia;
		else if ((angulo >= -90 && angulo < -30) || (angulo > 30 && angulo <= 90))
			distanciaEfectiva = 0.8 * distancia;
		else {
			this.esValido = false;
			distanciaEfectiva = 0;
		}
		return distanciaEfectiva;

	}

	public double getDistanciaEfectiva() {
		return distanciaEfectiva;
	}

	public boolean getEsValido() {
		return esValido;
	}
}
