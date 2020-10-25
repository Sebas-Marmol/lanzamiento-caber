package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import Competencia.Concurso;

class ProgramaCompletoTest {

	@Test
	void Caso_01_Test() {
		String nombre="Caso_01";
		Concurso concurso = new Concurso("pruebas/"+nombre);
		concurso.obtenerConcursantesArchivo();
		concurso.obtenerGanadoresDistancia();
		concurso.obtenerGanadoresConsistencia();
		concurso.generarArchivoSalida("pruebas/"+nombre);
		Scanner esperado=null;
		Scanner salida=null;
		try {
			esperado=new Scanner(new File("out/pruebas/esperados/"+nombre+".out")).useLocale(Locale.US);
			salida=new Scanner(new File("out/pruebas/"+nombre+".out")).useLocale(Locale.US);
			while(esperado.hasNextDouble() && salida.hasNextDouble()) {
				assertEquals(esperado.nextDouble(),salida.nextDouble());
			}
			if((esperado.hasNextDouble() && !salida.hasNextDouble()) || (!esperado.hasNextDouble() && salida.hasNextDouble()))
				fail("Distintas cantidades de caracteres");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Falta archivo");
		}
	}
	
	@Test
	void Caso_02_Test() {
		String nombre="Caso_02";
		Concurso concurso = new Concurso("pruebas/"+nombre);
		concurso.obtenerConcursantesArchivo();
		concurso.obtenerGanadoresDistancia();
		concurso.obtenerGanadoresConsistencia();
		concurso.generarArchivoSalida("pruebas/"+nombre);
		Scanner esperado=null;
		Scanner salida=null;
		try {
			esperado=new Scanner(new File("out/pruebas/esperados/"+nombre+".out")).useLocale(Locale.US);
			salida=new Scanner(new File("out/pruebas/"+nombre+".out")).useLocale(Locale.US);
			while(esperado.hasNextDouble() && salida.hasNextDouble()) {
				assertEquals(esperado.nextDouble(),salida.nextDouble());
			}
			if((esperado.hasNextDouble() && !salida.hasNextDouble()) || (!esperado.hasNextDouble() && salida.hasNextDouble()))
				fail("Distintas cantidades de caracteres");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Falta archivo");
		}
	}
	
	@Test
	void Caso_03_Test() {
		String nombre="Caso_03";
		Concurso concurso = new Concurso("pruebas/"+nombre);
		concurso.obtenerConcursantesArchivo();
		concurso.obtenerGanadoresDistancia();
		concurso.obtenerGanadoresConsistencia();
		concurso.generarArchivoSalida("pruebas/"+nombre);
		Scanner esperado=null;
		Scanner salida=null;
		try {
			esperado=new Scanner(new File("out/pruebas/esperados/"+nombre+".out")).useLocale(Locale.US);
			salida=new Scanner(new File("out/pruebas/"+nombre+".out")).useLocale(Locale.US);
			while(esperado.hasNextDouble() && salida.hasNextDouble()) {
				assertEquals(esperado.nextDouble(),salida.nextDouble());
			}
			if((esperado.hasNextDouble() && !salida.hasNextDouble()) || (!esperado.hasNextDouble() && salida.hasNextDouble()))
				fail("Distintas cantidades de caracteres");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Falta archivo");
		}
	}
	
	@Test
	void Caso_04_Test() {
		String nombre="Caso_04";
		//generarFatiga(nombre);
		Concurso concurso = new Concurso("pruebas/"+nombre);
		concurso.obtenerConcursantesArchivo();
		concurso.obtenerGanadoresDistancia();
		concurso.obtenerGanadoresConsistencia();
		concurso.generarArchivoSalida("pruebas/"+nombre);
		Scanner esperado=null;
		Scanner salida=null;
		try {
			esperado=new Scanner(new File("out/pruebas/esperados/"+nombre+".out")).useLocale(Locale.US);
			salida=new Scanner(new File("out/pruebas/"+nombre+".out")).useLocale(Locale.US);
			while(esperado.hasNextDouble() && salida.hasNextDouble()) {
				assertEquals(esperado.nextDouble(),salida.nextDouble());
			}
			if((esperado.hasNextDouble() && !salida.hasNextDouble()) || (!esperado.hasNextDouble() && salida.hasNextDouble()))
				fail("Distintas cantidades de caracteres");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Falta archivo");
		}
	}
	
	@Test
	void Caso_05_Test() {
		String nombre="Caso_05";
		Concurso concurso = new Concurso("pruebas/"+nombre);
		concurso.obtenerConcursantesArchivo();
		concurso.obtenerGanadoresDistancia();
		concurso.obtenerGanadoresConsistencia();
		concurso.generarArchivoSalida("pruebas/"+nombre);
		Scanner esperado=null;
		Scanner salida=null;
		try {
			esperado=new Scanner(new File("out/pruebas/esperados/"+nombre+".out")).useLocale(Locale.US);
			salida=new Scanner(new File("out/pruebas/"+nombre+".out")).useLocale(Locale.US);
			while(esperado.hasNextDouble() && salida.hasNextDouble()) {
				assertEquals(esperado.nextDouble(),salida.nextDouble());
			}
			if((esperado.hasNextDouble() && !salida.hasNextDouble()) || (!esperado.hasNextDouble() && salida.hasNextDouble()))
				fail("Distintas cantidades de caracteres");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Falta archivo");
		}
	}
	
	@Test
	void Caso_06_Test() {
		String nombre="Caso_06";
		Concurso concurso = new Concurso("pruebas/"+nombre);
		concurso.obtenerConcursantesArchivo();
		concurso.obtenerGanadoresDistancia();
		concurso.obtenerGanadoresConsistencia();
		concurso.generarArchivoSalida("pruebas/"+nombre);
		Scanner esperado=null;
		Scanner salida=null;
		try {
			esperado=new Scanner(new File("out/pruebas/esperados/"+nombre+".out")).useLocale(Locale.US);
			salida=new Scanner(new File("out/pruebas/"+nombre+".out")).useLocale(Locale.US);
			while(esperado.hasNextDouble() && salida.hasNextDouble()) {
				assertEquals(esperado.nextDouble(),salida.nextDouble());
			}
			if((esperado.hasNextDouble() && !salida.hasNextDouble()) || (!esperado.hasNextDouble() && salida.hasNextDouble()))
				fail("Distintas cantidades de caracteres");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Falta archivo");
		}
	}
	
	void generarFatiga(String nombre) {
		double offset=0;
		FileWriter archivo = null;
		PrintWriter pw = null;
		try {
			archivo = new FileWriter("in/pruebas/"+nombre+".in");
			pw = new PrintWriter(archivo);
			pw.println("999999");
			
			for(int i=0;i<999999;i++) {
				for(int j=0;j<3;j++)
					pw.println((2+offset*(j+1))+" "+89);
				offset+=0.00001;
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
