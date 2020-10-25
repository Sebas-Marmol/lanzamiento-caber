package Competencia;

public class App {

	public static void main(String[] args) {
		Concurso concurso = new Concurso("pruebas/Caso_04");
		concurso.obtenerConcursantesArchivo();
		concurso.obtenerGanadoresDistancia();
		concurso.obtenerGanadoresConsistencia();
		concurso.generarArchivoSalida("Ganadores");
	}

}
