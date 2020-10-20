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
		double promedio=0;
		for(Lanzamiento lanzamiento : lanzamientos) {
			promedio+=lanzamiento.distanciaEfectiva();
		}
		promedio/=lanzamientos.size();
		for(Lanzamiento lanzamiento : lanzamientos) {		
			consistencia+=(promedio-lanzamiento.distanciaEfectiva())*(promedio-lanzamiento.distanciaEfectiva());
		}
		consistencia/=lanzamientos.size();
		consistencia=Math.sqrt(consistencia);
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
	
	public boolean getDescalificado() {
		return this.descalificado;
	}
}