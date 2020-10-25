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
	private int[] ganadoresDistancia;
	private int[] ganadoresConsistencia;

	public Concurso(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
		ganadoresDistancia = new int[3];
		ganadoresConsistencia = new int[3];
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
				conc.validarLanzamientos();
				concursantes[i] = conc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			arch.close();
		}
	}

	public void obtenerGanadoresDistancia() {
		ArrayList<Concursante> array = new ArrayList<Concursante>();
		for (Concursante concursante : concursantes) {
			int pos;
			if (!concursante.getDescalificado()) {
				concursante.calcularDistanciaTotal();
				if ((pos = buscarPosDistancia(concursante.getDistanciaTotal(), array)) >= 0) {
					array.add(pos, concursante);
				}
			}
		}
		for (int i = 0; i < array.size() && i < 3; i++) {
			this.ganadoresDistancia[i] = array.get(i).getIDConcursante();
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

	public void obtenerGanadoresConsistencia() {
		ArrayList<Concursante> array = new ArrayList<Concursante>();
		for (Concursante concursante : concursantes) {
			int pos;
			if (!concursante.getDescalificado()) {
				concursante.calcularConsistencia();
				if ((pos = buscarPosConsistencia(concursante.getConsistencia(), array)) >= 0) {
					array.add(pos, concursante);
					System.out.println(concursante.getConsistencia());
				}
			}
		}
		for (int i = 0; i < array.size() && i < 3; i++) {
			this.ganadoresConsistencia[i] = array.get(i).getIDConcursante();
		}
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
			for (int i : ganadoresConsistencia)
				if (i != 0)
					pw.print(i + " ");
			pw.print("\n");
			for (int i : ganadoresDistancia)
				if (i != 0)
					pw.print(i + " ");
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
