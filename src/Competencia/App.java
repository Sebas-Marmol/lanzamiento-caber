package Competencia;

public class App {

	public static void main(String[] args) {
		Concurso concurso = new Concurso();
		concurso.obtenerConcursantesArchivo();
		concurso.obtenerGanadoresDistancia();
		concurso.obtenerGanadoresConsistencia();
		concurso.generarArchivoSalida();
	}

}
