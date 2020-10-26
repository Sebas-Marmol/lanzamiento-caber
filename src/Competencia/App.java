package Competencia;

public class App {

	public static void main(String[] args) {
		Concurso concurso = new Concurso("DatosConcurso");
		concurso.obtenerConcursantesArchivo();
		concurso.generarArchivoSalida("Ganadores");
	}

}
