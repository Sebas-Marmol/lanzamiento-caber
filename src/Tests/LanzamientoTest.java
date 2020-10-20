package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Competencia.*;

class LanzamientoTest {

	@Test
	void tiroInvalidoNegativoTest() {
		Lanzamiento l = new Lanzamiento(10, -100);
		assertEquals(l.distanciaEfectiva(), 0);
	}

	@Test
	void tiroInvalidoPositivoTest() {
		Lanzamiento l = new Lanzamiento(10, 100);
		assertEquals(l.distanciaEfectiva(), 0);
	}

	@Test
	void tiroInvalidoLlanoTest() {
		Lanzamiento l = new Lanzamiento(10, 180);
		assertEquals(l.distanciaEfectiva(), 0);
	}

	@Test
	void tiroRegularNegativoTest() {
		Lanzamiento l = new Lanzamiento(10, -40);
		assertEquals(l.distanciaEfectiva(), 8);
	}

	@Test
	void tiroRegularIgualNegativoTest() {
		Lanzamiento l = new Lanzamiento(10, -90);
		assertEquals(l.distanciaEfectiva(), 8);
	}

	@Test
	void tiroRegularIgualPositivoTest() {
		Lanzamiento l = new Lanzamiento(10, 90);
		assertEquals(l.distanciaEfectiva(), 8);
	}

	@Test
	void tiroRegularPositivoTest() {
		Lanzamiento l = new Lanzamiento(10, 40);
		assertEquals(l.distanciaEfectiva(), 8);
	}

	@Test
	void tiroBuenoPositivoTest() {
		Lanzamiento l = new Lanzamiento(10, 20);
		assertEquals(l.distanciaEfectiva(), 10);
	}

	@Test
	void tiroBuenoNegativoTest() {
		Lanzamiento l = new Lanzamiento(10, -20);
		assertEquals(l.distanciaEfectiva(), 10);
	}

	@Test
	void tiroBuenoIgualPositivoTest() {
		Lanzamiento l = new Lanzamiento(10, 30);
		assertEquals(l.distanciaEfectiva(), 10);
	}

	@Test
	void tiroBuenoIgualNegativoTest() {
		Lanzamiento l = new Lanzamiento(10, -30);
		assertEquals(l.distanciaEfectiva(), 10);
	}

	@Test
	void tiroBuenoTest() {
		Lanzamiento l = new Lanzamiento(10, 0);
		assertEquals(l.distanciaEfectiva(), 10);
	}

}
