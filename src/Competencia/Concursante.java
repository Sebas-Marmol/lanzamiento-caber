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

		for (Lanzamiento lanzamiento : lanzamientos) {
			this.distanciaTotal += lanzamiento.distanciaEfectiva();
		}
		return this.distanciaTotal;
	}

	public double calcularConsistencia() {

		// TO-DO implementar desviacion estandar.

	}

	public void validarLanzamientos() {

		for (Lanzamiento lanzamiento : lanzamientos) {
			if (!lanzamiento.getEsValido()) {
				this.descalificado = true;
				return;
			}
		}
	}
}