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
		lanzamientos.add(lanz);
	}

	public double calcularDistanciaTotal() {
		if (descalificado)
			return 0;
		for (Lanzamiento lanzamiento : lanzamientos) {
			this.distanciaTotal += lanzamiento.distanciaEfectiva();
			if (!lanzamiento.getEsValido()) {
				descalificado = true;
				return 0;
			}
		}
		return this.distanciaTotal;
	}

	public double calcularConsistencia() {
		if (descalificado)
			return 0;
		double promedio = 0;
		for (Lanzamiento lanzamiento : lanzamientos) {
			promedio += lanzamiento.distanciaEfectiva();
			if (!lanzamiento.getEsValido()) {
				descalificado = true;
				return 0;
			}
		}
		promedio /= lanzamientos.size();
		for (Lanzamiento lanzamiento : lanzamientos) {
			consistencia += (promedio - lanzamiento.distanciaEfectiva()) * (promedio - lanzamiento.distanciaEfectiva());
		}
		consistencia /= lanzamientos.size();
		consistencia = Math.sqrt(consistencia);
		return this.consistencia;
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