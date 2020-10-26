package Competencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Concurso {
	private String nombreArchivo;
	private List<Concursante> ganadoresDistancia;
	private List<Concursante> ganadoresConsistencia;

	public Concurso(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
		ganadoresDistancia = new ArrayList<Concursante>(3);
		ganadoresConsistencia = new ArrayList<Concursante>(3);
	}

	public void obtenerConcursantesArchivo() {
		Scanner arch = null;
		try {
			arch = new Scanner(new File("in/" + this.nombreArchivo + ".in")).useLocale(Locale.US);
			int participantes = arch.nextInt();
			for (int i = 0; i < participantes; i++) {
				Concursante conc = new Concursante(i + 1);
				conc.registrarLanzamiento(new Lanzamiento(arch.nextDouble(), arch.nextDouble()));
				conc.registrarLanzamiento(new Lanzamiento(arch.nextDouble(), arch.nextDouble()));
				conc.registrarLanzamiento(new Lanzamiento(arch.nextDouble(), arch.nextDouble()));
				conc.validarLanzamientos();
				conc.calcularDistanciaTotal();
				preguntarGanadoresDistancia(conc);
				conc.calcularConsistencia();
				preguntarGanadoresConsistencia(conc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			arch.close();
		}
	}

	public void preguntarGanadoresDistancia(Concursante actual) {
		if (ganadoresDistancia.size() == 0) {
			if (!actual.getDescalificado())
				ganadoresDistancia.add(actual);
		} else {
			Concursante aux;
			int i;
			for (i = 0; i < ganadoresDistancia.size(); i++)
				if (!actual.getDescalificado())
					if (ganadoresDistancia.get(i).getDistanciaTotal() < actual.getDistanciaTotal()) {
						aux = ganadoresDistancia.remove(i);
						ganadoresDistancia.add(i, actual);
						actual = aux;
					}
			if (i < 3)
				ganadoresDistancia.add(actual);
		}
	}

	public void preguntarGanadoresConsistencia(Concursante actual) {
		if (ganadoresConsistencia.size() == 0) {
			if (!actual.getDescalificado())
				ganadoresConsistencia.add(actual);
		} else {
			Concursante aux;
			int i;
			for (i = 0; i < ganadoresConsistencia.size(); i++)
				if (!actual.getDescalificado())
					if (ganadoresConsistencia.get(i).getConsistencia() > actual.getConsistencia()) {
						aux = ganadoresConsistencia.remove(i);
						ganadoresConsistencia.add(i, actual);
						actual = aux;
					}
			if (i < 3)
				ganadoresConsistencia.add(actual);
		}
	}

	public void generarArchivoSalida(String nombre) {
		FileWriter archivo = null;
		PrintWriter pw = null;
		try {
			archivo = new FileWriter("out/" + nombre + ".out");
			pw = new PrintWriter(archivo);
			for (Concursante concursante : ganadoresConsistencia) {
				pw.print(concursante.getIDConcursante() + " ");
			}
			System.out.println();
			pw.print("\n");
			for (Concursante concursante : ganadoresDistancia) {
				pw.print(concursante.getIDConcursante() + " ");
			}
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
