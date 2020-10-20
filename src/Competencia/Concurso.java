package Competencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
			this.concursantes = new Concursante[participantes];
			for (int i = 0; i < participantes; i++) {
				Concursante conc = new Concursante(i);
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
		for(Concursante concursante : concursantes) {
			if(!concursante.getDescalificado()) {
				
			}
		}
	}

	public void generarArchivoSalida() {
		FileWriter archivo = null;
		PrintWriter pw = null;
		try {
			archivo = new FileWriter("out/Resumen.out");
			pw = new PrintWriter(archivo);
			for(int i : ganadoresConsistencia)
				pw.print(i+" ");
			pw.print("\n");
			for(int i : ganadoresDistancia)
				pw.print(i);
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
