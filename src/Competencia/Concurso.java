package Competencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Concurso {

	private Concursante[] concursantes;
	private int[] ganadoresDistancia;
	private int[] ganadoresConsistencia;

	public Concurso() {
		ganadoresDistancia = new int[3];
		ganadoresConsistencia = new int[3];
	}

	public void obtenerConcursantesArchivo() {
		Scanner arch = null;
		try {
			arch = new Scanner(new File("in/DatosConcurso.in"));
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

	public void obtenerGanadoresDistancia() {
		ArrayList<Concursante> array = new ArrayList<Concursante>();
		for (Concursante concursante : concursantes) {
			int pos;
			concursante.calcularDistanciaTotal();
			if (!concursante.getDescalificado()
					&& (pos = buscarPosDistancia(concursante.getDistanciaTotal(), array)) >= 0) {
				array.add(pos, concursante);
				System.out.println(concursante.getIDConcursante());
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

	public void generarArchivoSalida() {
		FileWriter archivo = null;
		PrintWriter pw = null;
		try {
			archivo = new FileWriter("out/Ganadores.out");
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
