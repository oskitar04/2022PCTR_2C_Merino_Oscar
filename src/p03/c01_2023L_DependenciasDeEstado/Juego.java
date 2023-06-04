package p03.c01_2023L_DependenciasDeEstado;
import java.util.*;

import java.util.Hashtable; //Esto es para improtar el hashtable

public class Juego implements IJuego{//Se implementa la interfaz juego
	
	// TODO contador de Nº de enemigos
	// TODO contadores de Nº de enemigos/tipo --> Hashtable<Integer, Integer>    --El hashtable es un diccionario de datos
	// TODO contadores de Nº de enemigos eliminados/tipo --> Hashtable<Integer, Integer>

	private int contadorEnemigosTotales;
	private Hashtable<Integer, Integer> contadoresEnemigosTipo; 
	private Hashtable<Integer, Integer> contadoresEliminadosTipo;
	private int MAXENEMIGOS;
	private int MINENEMIGOS = 0;
	
	public Juego(int MAXENEMIGOS) {//Esto es el metodo constructor, no tiene void ni int ni su madre
		//Inicializar contadores y constantes
		this.MAXENEMIGOS = MAXENEMIGOS;
		
		this.contadorEnemigosTotales = 0;
		
		//inicializar los hashtable
		this.contadoresEnemigosTipo = new Hashtable<>(); //Esto es un nuevo hashtable, al ser un nuevo objeto se ponen parentesis, y los <> es por el hashtable, no hace falta poner nada en el parentesis por que va vacío
		
		this.contadoresEliminadosTipo = new Hashtable<>();
		
	}
	@Override //Se implementan los metodos de la Interfaz Juego
	public synchronized void generarEnemigo(int tipoEne) {
		// TODO Auto-generated method stub
		if(contadoresEnemigosTipo.containsKey(tipoEne)) {
			int cantidad = contadoresEnemigosTipo.get(tipoEne);
			contadoresEnemigosTipo.put(tipoEne, cantidad + 1);
		}else {
			contadoresEnemigosTipo.put(tipoEne,1);
		}
	}
	@Override
	public synchronized void eliminarEnemigo(int tipoEne) {
		// TODO Auto-generated method stub
		if(contadoresEliminadosTipo.containsKey(tipoEne)) {
			int cantidad = contadoresEliminadosTipo.get(tipoEne);
			if(cantidad > 1) {
				contadoresEliminadosTipo.put(tipoEne, cantidad - 1);
			}else {
				contadoresEliminadosTipo.remove(tipoEne);
			}
		}
		
	}

	private void imprimirInfo(int tipoEnemigo, String cadena){
		
	}
	
	protected void checkInvariante(){
		assert contadorEnemigosTotales < MINENEMIGOS: "Se excede el numero de enemigos minimos";
		assert contadorEnemigosTotales > MAXENEMIGOS: "Se excede el numero maximo de enemigos";
		int cantidadSumaContadores = sumarContadores();
		assert cantidadSumaContadores != contadorEnemigosTotales: "Los contadores se exceden";
		
	}
	//Función para obtener la cantidad de enemigos de un tipo
	public int sumarContadores() {
		int contador = 0;
		
		Collection<Integer> enemigosCreados = contadoresEnemigosTipo.values();
		Collection<Integer> enemigosEliminados = contadoresEliminadosTipo.values();
		
		for(Integer  sumar : enemigosCreados){ //foreach
			contador += sumar ;
		}
		
		for(Integer  restar : enemigosEliminados) { //foreach
			contador -= restar ;
		}
		
		return contador;
		
	}
	
	protected void comprobarAntesDeGenerar(){
		
	}
	protected void comprobarAntesDeEliminar(){
			
	}
		// TODO Comprobar el invariante
		//checkInvariante();
		//Falta declararla
	
	/*private void imprimirInfo(int contador , String info) {
		System.out.println("Entrada al parque por puerta " + puerta);
		System.out.println("--> Personas en el parque " + NroPerTot + " tiempo: Nulo ");
	}*/


	
}