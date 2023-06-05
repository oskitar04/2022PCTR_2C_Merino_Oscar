package p03.c01_2023L_DependenciasDeEstado;

import java.util.*;

import java.util.Hashtable; //Esto es para improtar el hashtable

public class Juego implements IJuego {// Se implementa la interfaz juego

	// TODO contador de Nº de enemigos
	// TODO contadores de Nº de enemigos/tipo --> Hashtable<Integer, Integer> --El
	// TODO hashtable es un diccionario de datos
	// TODO contadores de Nº de enemigos eliminados/tipo --> Hashtable<Integer,Integer>

	private int contadorEnemigosTotales;
	private Hashtable<Integer, Integer> contadoresEnemigosTipo;
	private Hashtable<Integer, Integer> contadoresEliminadosTipo;
	private int MAXENEMIGOS;
	private int MINENEMIGOS = 0;

	public Juego(int tiposEnemigos, int MAXENEMIGOS) {// Esto es el metodo constructor, no tiene void ni int ni su madre
		// Inicializar contadores y constantes
		this.MAXENEMIGOS = MAXENEMIGOS;

		this.contadorEnemigosTotales = 0;
		
		tiposEnemigos = MAXENEMIGOS;

		// inicializar los hashtable
		this.contadoresEnemigosTipo = new Hashtable<>(); // Esto es un nuevo hashtable, al ser un nuevo objeto se ponen
															// parentesis, y los <> es por el hashtable, no hace falta
															// poner nada en el parentesis por que va vacío
		this.contadoresEliminadosTipo = new Hashtable<>();
	}

	@Override // Se implementan los metodos de la Interfaz Juego
	public synchronized void generarEnemigo(int tipoEne) {
		// Miramos si el enemigo existe antes de crearlo
		if (tipoEne != 0) {
			comprobarAntesDeGenerar(tipoEne);
		} else {

			// TODO Auto-generated method stub
			if (contadoresEnemigosTipo.containsKey(tipoEne)) {
				int cantidad = contadoresEnemigosTipo.get(tipoEne);
				
				
				
				System.out.println("MUERTE SUBITA");
				
				
				
				contadoresEnemigosTipo.put(tipoEne, cantidad + 1);
			} else {
				contadoresEnemigosTipo.put(tipoEne, 1);
			}
		}
		contadorEnemigosTotales++;// Se aumenta porque se crea un enemigo
		checkInvariante();
		imprimirInfo(tipoEne, "Generado");
		notifyAll();

	}

	@Override
	public synchronized void eliminarEnemigo(int tipoEne) {
		// Miramos si el numero de enemigos es mas que 0 para antes de eliminarlo
		if (tipoEne != 0) {
			comprobarAntesDeEliminar(tipoEne);
		}
		// TODO Auto-generated method stub
		if (contadoresEliminadosTipo.containsKey(tipoEne)) {
			int cantidad = contadoresEliminadosTipo.get(tipoEne);
			
			
			
			System.out.println("AGUACATE");
			
			
			
			contadoresEnemigosTipo.put(tipoEne, cantidad + 1);
		} else {
			contadoresEliminadosTipo.put(tipoEne, 0);
		}
		contadorEnemigosTotales--;// Se disminue porque se crea un enemigo

		checkInvariante();

		imprimirInfo(tipoEne, "Eliminado");

		notifyAll();

	}

	private void imprimirInfo(int tipoEne, String informacion) {
		for (int i = 0; i < MAXENEMIGOS; i++) {
			System.out.println(informacion + " enemigo tipo " + tipoEne);
			/*System.out.println("--> Enemigos totales: " + contadorEnemigosTotales);
			for (int j : contadoresEnemigosTipo.keySet()) {
				// int valorEnemigos = contadoresEnemigosTipo.get(j);
				// int valoresEliminados = contadoresEliminadosTipo.get(j);
				System.out.println("--> Enemigos tipo " + j + ": " + contadoresEnemigosTipo.get(j)
						+ " ------ [Eliminados:" + contadoresEliminadosTipo.get(j) + "]");
			}*/
			System.out.println(" ");
		}
	}

	public int sumarContadores() {
		// Sirve para tener un contador de los enemigos que hay actualmente
		int contador = 0;

		Collection<Integer> enemigosCreados = contadoresEnemigosTipo.values();
		Collection<Integer> enemigosEliminados = contadoresEliminadosTipo.values();

		for (Integer sumar : enemigosCreados) { // foreach
			contador += sumar;
		}

		for (Integer restar : enemigosEliminados) { // foreach
			contador -= restar;
		}

		return contador;

	}

	protected void checkInvariante() {
		// TODO Comprobar el invariante
		assert contadorEnemigosTotales < MINENEMIGOS : "Se excede el numero de enemigos minimos";
		assert contadorEnemigosTotales > MAXENEMIGOS : "Se excede el numero maximo de enemigos";
		int cantidadSumaContadores = sumarContadores();
		assert cantidadSumaContadores != contadorEnemigosTotales : "Los contadores se exceden";

	}

	protected void comprobarAntesDeGenerar(int tipoEne) {
		int enemigoAntes = tipoEne - 1;
		while (contadoresEnemigosTipo.contains(enemigoAntes) == false || contadorEnemigosTotales <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected void comprobarAntesDeEliminar(int tipoEne) {
		while (contadoresEnemigosTipo.contains(tipoEne) == false || contadoresEliminadosTipo.get(tipoEne) <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}