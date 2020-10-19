package Competencia;

import java.io.File;
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
				Concursante conc=new Concursante();
				conc.registrarLanzamiento(new Lanzamiento(arch.nextDouble(),arch.nextDouble()));
				conc.registrarLanzamiento(new Lanzamiento(arch.nextDouble(),arch.nextDouble()));
				conc.registrarLanzamiento(new Lanzamiento(arch.nextDouble(),arch.nextDouble()));
				concursantes[i]=conc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			arch.close();
		}
	}
}
