package Competencia;

import java.util.ArrayList;

public class Concursante {

	private int IDConcursante;
	private ArrayList<Lanzamiento> lanzamientos;
	private double consistencia;
	private double distanciaTotal;
	private Boolean descalificado;

	Concursante(int IDConcursante) {
		this.IDConcursante = IDConcursante;
		lanzamientos = new ArrayList<Lanzamiento>();
		distanciaTotal = 0;
		consistencia = 0;
		descalificado = false;
	}

	public void registrarLanzamiento(Lanzamiento lanz) {
		lanz.distanciaEfectiva();
		lanzamientos.add(lanz);
	}

	public double calcularDistanciaTotal() {
		for (Lanzamiento lanzamiento : lanzamientos) {
			this.distanciaTotal += lanzamiento.getDistanciaEfectiva();
		}
		return this.distanciaTotal;
	}

	public double calcularConsistencia() {
		if (descalificado)
			return 0;
		double promedio = 0;
		for (Lanzamiento lanzamiento : lanzamientos) {
			promedio += lanzamiento.getDistanciaEfectiva();
		}
		promedio /= lanzamientos.size();
		for (Lanzamiento lanzamiento : lanzamientos) {
			consistencia += (promedio - lanzamiento.getDistanciaEfectiva())
					* (promedio - lanzamiento.getDistanciaEfectiva());
		}
		consistencia /= lanzamientos.size();
		consistencia = Math.sqrt(consistencia);
		return this.consistencia;
	}

	public void validarLanzamientos() {

		for (Lanzamiento lanzamiento : lanzamientos) {
			if (!lanzamiento.getEsValido()) {
				this.descalificado = true;
				return;
			}
		}
	}

	public double getConsistencia() {
		return consistencia;
	}

	public int getIDConcursante() {
		return IDConcursante;
	}

	public double getDistanciaTotal() {
		return distanciaTotal;
	}

	public boolean getDescalificado() {
		return this.descalificado;
	}
}