package fp.grados.tipos.test;

import java.util.List;

import fp.grados.excepciones.ExcepcionBecaNoValida;
import fp.grados.tipos.Beca;
import fp.grados.tipos.BecaImpl;
import fp.grados.tipos.TipoBeca;
import fp.grados.utiles.Grados;

public class TestBeca {

	public static void main(String[] args) {
		testConstructorString();

		testConstructor1Normal();
		testConstructor1Excepcion1();
		testConstructor1Excepcion2();
		testConstructor1Excepcion3();
		testConstructor1Excepcion4();
		testConstructor1Excepcion5();
		testConstructor1Excepcion6();

		testConstructor2Normal();
		testConstructor2Excepcion1();
		testConstructor2Excepcion2();
		testConstructor2Excepcion3();
		testConstructor2Excepcion4();

		testSetCuantiaTotalNormal();
		testSetCuantiaTotalExcepcion1();

		testSetDuracionNormal();
		testSetDuracionExcepcion1();

		testIgualdad();
		testOrden();
	}

	// Casos de prueba

	private static void testConstructorString() {
		List<Beca> becas = Grados.leeFichero("res/becas.txt", s -> new BecaImpl(s));
		for (Beca b : becas) {
			mostrarBeca(b);
		}
	}

	private static void testConstructor1Normal() {
		System.out.println("==================================Probando el primer constructor");
		testConstructor1("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
	}

	private static void testConstructor1Excepcion1() {
		System.out.println(
				"==================================Probando el primer constructor, pocos caracteres en el c�digo");
		testConstructor1("ABC12", 10000.0, 6, TipoBeca.ORDINARIA);
	}

	private static void testConstructor1Excepcion2() {
		System.out.println(
				"==================================Probando el primer constructor, demasiados caracteres en el c�digo");
		testConstructor1("ABC12345", 10000.0, 6, TipoBeca.ORDINARIA);
	}

	private static void testConstructor1Excepcion3() {
		System.out
				.println("==================================Probando el primer constructor, pocas letras en el c�digo");
		testConstructor1("AB12345", 10000.0, 6, TipoBeca.ORDINARIA);
	}

	private static void testConstructor1Excepcion4() {
		System.out.println(
				"==================================Probando el primer constructor, pocos d�gitos en el c�digo");
		testConstructor1("ABCD123", 10000.0, 6, TipoBeca.ORDINARIA);
	}

	private static void testConstructor1Excepcion5() {
		System.out.println(
				"==================================Probando el primer constructor, cuant�a total menor a la m�nima");
		testConstructor1("ABC1234", 0.0, 6, TipoBeca.ORDINARIA);
	}

	private static void testConstructor1Excepcion6() {
		System.out.println("==================================Probando el primer constructor, duraci�n menor a 1");
		testConstructor1("ABC1234", 10000.0, -1, TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Normal() {
		System.out.println("==================================Probando el segundo constructor");
		testConstructor2("ABC1234", TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Excepcion1() {
		System.out.println(
				"==================================Probando el segundo constructor, pocos caracteres en el c�digo");
		testConstructor2("ABC12", TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Excepcion2() {
		System.out.println(
				"==================================Probando el segundo constructor, demasiados caracteres en el c�digo");
		testConstructor2("ABC12345", TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Excepcion3() {
		System.out.println(
				"==================================Probando el segundo constructor, pocas letras en el c�digo");
		testConstructor2("AB12345", TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Excepcion4() {
		System.out.println(
				"==================================Probando el segundo constructor, pocos d�gitos en el c�digo");
		testConstructor2("ABCD123", TipoBeca.ORDINARIA);
	}

	private static void testSetCuantiaTotalNormal() {
		System.out.println("==================================Probando setCuantiaTotal");
		Beca b = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		testSetCuantiaTotal(b, 12000.0);
	}

	private static void testSetCuantiaTotalExcepcion1() {
		System.out.println(
				"==================================Probando setCuantiaTotal con cuant�a total menor a la m�nima");
		Beca b = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		testSetCuantiaTotal(b, 120.0);
	}

	private static void testSetDuracionNormal() {
		System.out.println("==================================Probando setDuracion");
		Beca b = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		testSetDuracion(b, 12);
	}

	private static void testSetDuracionExcepcion1() {
		System.out.println("==================================Probando setDuracion con duraci�n menor a 1");
		Beca b = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		testSetDuracion(b, 0);
	}

	private static void testIgualdad() {
		System.out.println("\n===============================Probando igualdad");
		// Creamos dos objetos iguales (mismo c�digo, mismo tipo de beca,
		// el resto distinto)
		Beca b1 = new BecaImpl("ABC1234", 2000.0, 12, TipoBeca.EMPRESA);
		Beca b2 = new BecaImpl("ABC1234", 3000.0, 6, TipoBeca.EMPRESA);
		// Creamos objetos distintos (distinto c�digo, distinto tipo de beca)
		Beca b3 = new BecaImpl("ZWQ9877", 2000.0, 12, TipoBeca.EMPRESA);
		Beca b4 = new BecaImpl("ABC1234", 3000.0, 6, TipoBeca.MOVILIDAD);
		System.out.println("C�digo hash del objeto b1 (" + b1 + "): " + b1.hashCode());
		System.out.println("C�digo hash del objeto b2 (" + b2 + "): " + b2.hashCode());
		System.out.println("C�digo hash del objeto b3 (" + b3 + "): " + b3.hashCode());
		System.out.println("C�digo hash del objeto b4 (" + b4 + "): " + b4.hashCode());
		System.out.println("�Es b1 igual a b2? (debe ser true): " + b1.equals(b2));
		System.out.println("�Es b1 distinto de b3? (debe ser true): " + !b1.equals(b3));
		System.out.println("�Es b1 distinto de b4? (debe ser true): " + !b1.equals(b4));
	}

	private static void testOrden() {
		System.out.println("\n===============================Probando orden natural");
		// Creamos cuatro objetos tales que menor < igual1 == igual2 < mayor
		Beca menor = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		Beca igual1 = new BecaImpl("ABC1235", 10000.0, 6, TipoBeca.ORDINARIA);
		Beca igual2 = new BecaImpl("ABC1235", 10000.0, 6, TipoBeca.ORDINARIA);
		Beca mayor = new BecaImpl("ABC1235", 10000.0, 6, TipoBeca.EMPRESA);
		System.out.print("(debe ser ANTES) ");
		compara(menor, igual1);
		System.out.print("(debe ser MISMA POSICI�N) ");
		compara(igual1, igual2);
		System.out.print("(debe ser ANTES) ");
		compara(igual2, mayor);
	}

	// M�todos auxiliares
	private static void compara(Beca b1, Beca b2) {
		System.out.print("El objeto <" + b1 + ">");
		if (b1.compareTo(b2) < 0) {
			System.out.print(" va ANTES que el objeto ");
		} else if (b1.compareTo(b2) > 0) {
			System.out.print(" va DESPU�S que el objeto ");
		} else {
			System.out.print(" va en la MISMA POSICI�N que el objeto ");
		}
		System.out.println("<" + b2 + ">");
	}

	private static void testConstructor1(String codigo, Double cuantiaTotal, Integer duracion, TipoBeca tipo) {
		try {
			Beca b = new BecaImpl(codigo, cuantiaTotal, duracion, tipo);
			mostrarBeca(b);
		} catch (ExcepcionBecaNoValida e) {
			System.out.println("******************** Se ha capturado la excepci�n ExcepcionBecaNoValida");
		} catch (Exception e) {
			System.out.println("******************** ���Se ha capturado una EXCEPCI�N INESPERADA!!!");
		}
	}

	private static void testConstructor2(String codigo, TipoBeca tipo) {
		try {
			Beca b = new BecaImpl(codigo, tipo);
			mostrarBeca(b);
		} catch (ExcepcionBecaNoValida e) {
			System.out.println("******************** Se ha capturado la excepci�n ExcepcionBecaNoValida");
		} catch (Exception e) {
			System.out.println("******************** ���Se ha capturado una EXCEPCI�N INESPERADA!!!");
		}
	}

	private static void testSetCuantiaTotal(Beca b, Double cuantiaTotal) {
		try {
			System.out.println("La cuant�a total antes de la operaci�n es: " + b.getCuantiaTotal());
			System.out.println("El nuevo valor es: " + cuantiaTotal);
			b.setCuantiaTotal(cuantiaTotal);
			System.out.println("La cuant�a total despu�s de la operaci�n es: " + b.getCuantiaTotal());
		} catch (ExcepcionBecaNoValida e) {
			System.out.println("******************** Se ha capturado la excepci�n ExcepcionBecaNoValida");
		} catch (Exception e) {
			System.out.println("******************** ���Se ha capturado una EXCEPCI�N INESPERADA!!!");
		}
	}

	private static void testSetDuracion(Beca b, Integer duracion) {
		try {
			System.out.println("La duraci�n antes de la operaci�n es: " + b.getDuracion());
			System.out.println("El nuevo valor es: " + duracion);
			b.setDuracion(duracion);
			System.out.println("La duraci�n despu�s de la operaci�n es: " + b.getDuracion());
		} catch (ExcepcionBecaNoValida e) {
			System.out.println("******************** Se ha capturado la excepci�n ExcepcionBecaNoValida");
		} catch (Exception e) {
			System.out.println("******************** ���Se ha capturado una EXCEPCI�N INESPERADA!!!");
		}
	}

	private static void mostrarBeca(Beca b) {
		System.out.println("Beca --> <" + b + ">");
		System.out.println("\tC�digo: <" + b.getCodigo() + ">");
		System.out.println("\tCuant�a total: <" + b.getCuantiaTotal() + ">");
		System.out.println("\tDuraci�n: <" + b.getDuracion() + ">");
		System.out.println("\tTipo: <" + b.getTipo() + ">");
		System.out.println("\tCuant�a mensual: <" + b.getCuantiaMensual() + ">");
	}

}