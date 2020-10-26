package Competencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Concurso {
	private String nombreArchivo;
	private Concursante[] concursantes;
	private Concursante[] ganadoresDistancia;
	private Concursante[] ganadoresConsistencia;

	public Concurso(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
		ganadoresDistancia = new Concursante[3];
		ganadoresConsistencia = new Concursante[3];
	}

	public void obtenerConcursantesArchivo() {
		Scanner arch = null;
		try {
			arch = new Scanner(new File("in/" + this.nombreArchivo + ".in")).useLocale(Locale.US);
			int participantes = arch.nextInt();
			concursantes = new Concursante[participantes];
			for (int i = 0; i < participantes; i++) {
				Concursante conc = new Concursante(i + 1);
				conc.registrarLanzamiento(new Lanzamiento(arch.nextDouble(), arch.nextDouble()));
				conc.registrarLanzamiento(new Lanzamiento(arch.nextDouble(), arch.nextDouble()));
				conc.registrarLanzamiento(new Lanzamiento(arch.nextDouble(), arch.nextDouble()));
				concursantes[i] = conc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			arch.close();
		}
	}

	public void obtenerPodios() {
		ArrayList<Concursante> arrayDistancia = new ArrayList<Concursante>();
		ArrayList<Concursante> arrayConsistencia = new ArrayList<Concursante>();
		for (Concursante concursante : concursantes) {
			int pos;
			concursante.validarLanzamientos();
			if (!concursante.getDescalificado()) {
				concursante.calcularDistanciaTotal();
				if ((pos = buscarPosDistancia(concursante.getDistanciaTotal(), arrayDistancia)) >= 0) {
					arrayDistancia.add(pos, concursante);
				}
				concursante.calcularConsistencia();
				if ((pos = buscarPosConsistencia(concursante.getConsistencia(), arrayConsistencia)) >= 0) {
					arrayConsistencia.add(pos, concursante);
				}
			}
		}
		for (int i = 0; i < arrayConsistencia.size() && i < 3; i++) {
			this.ganadoresConsistencia[i] = arrayConsistencia.get(i);
			this.ganadoresDistancia[i] = arrayDistancia.get(i);
		}
	}

	private int buscarPosDistancia(double distancia, ArrayList<Concursante> array) {
		int i = 0;
		while (i < array.size() && i < 3) {
			if (distancia > array.get(i).getDistanciaTotal())
				return i;
			i++;
		}
		if (i < 3)
			return i;
		return -1;

	}

	private int buscarPosConsistencia(double consistencia, ArrayList<Concursante> array) {
		int i = 0;
		while (i < array.size() && i < 3) {
			if (consistencia < array.get(i).getConsistencia())
				return i;
			i++;
		}
		if (i < 3)
			return i;
		return -1;

	}

	public void generarArchivoSalida(String nombre) {
		FileWriter archivo = null;
		PrintWriter pw = null;
		try {
			archivo = new FileWriter("out/" + nombre + ".out");
			pw = new PrintWriter(archivo);
			for (Concursante conc : ganadoresConsistencia)
				if (conc != null)
					pw.print(conc.getIDConcursante() + " ");
			pw.print("\n");
			for (Concursante conc : ganadoresDistancia)
				if (conc != null)
					pw.print(conc.getIDConcursante() + " ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (archivo != null) {
				try {
					archivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
