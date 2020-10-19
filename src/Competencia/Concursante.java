package Competencia;

import java.util.ArrayList;

public class Concursante {

	private ArrayList<Lanzamiento> lanzamientos;

	public Concursante() {
		this.lanzamientos = new ArrayList<Lanzamiento>();
	}

	public void registrarLanzamiento(Lanzamiento nuevoLanzamiento) {
		this.lanzamientos.add(nuevoLanzamiento);
	}
}
