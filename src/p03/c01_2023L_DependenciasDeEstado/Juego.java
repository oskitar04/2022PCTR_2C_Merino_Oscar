package p03.c01_2023L_DependenciasDeEstado;
import java.util.concurrent.TimeUnit;

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
	
	public Juego(MAXENEMIGOS, MINENEMIGOS) {//Esto es el metodo constructor, no tiene void ni int ni su madre
		
		contadorEnemigosTotales = 0;
		
		contadoresEnemigosTipo = new Hashtable<Integer,Integer>(MAXENEMIGOS,MINENEMIGOS); //Esto es un nuevo hashtable, al ser un nuevo objeto se ponen parentesis, y los <> es por el hashtable, no hace falta poner nada en el parentesis por que va vacío
		
		contadoresEliminadosTipo = new Hashtable<Integer, Integer>(MAXENEMIGOS,MINENEMIGOS);
	}
	//@Override
	/*public synchronized void generarEnemigo(IJuego tipoEne) {//El synchronized se usa para sincronizar a la hora de contar
		
		// TODO Inicializar claves (del diccionario)
		if(EnemigosTipo.containsKey(tipoEne)==true) {
			int contene = EnemigosTipo.get(tipoEne);
			EnemigosTipo.put(tipoEne, contene + 1);
		}
		
		int gente = EnemigosTipo.get(tipoEne); //El get en este caso solo es para el hashtable
		//EnemigosTipo.put(genEne, (gente+1)); //Esto lo actualiza y hace que entre la gente en este caso
		System.out.println(gente);
		
		// TODO Mensaje
		
		if(EnemigosTipo.get(tipoEne) == null) {
			EnemigosTipo.put(tipoEne, 0);
		}
		//EnemigosTipo.put(genEne, contPuerta);
		
		
		// TODO Comprobar el invariante
		//checkInvariante();
		//Falta declararla
		protected void checkInvariante(){
			assert suamrContadorPuerta() == NroPerTot : "INV la suma";
		}
		
		private int sumarContadorPuerta() {
			return;
		}
	}
	
	/*private void imprimirInfo(int contador , String info) {
		System.out.println("Entrada al parque por puerta " + puerta);
		System.out.println("--> Personas en el parque " + NroPerTot + " tiempo: Nulo ");
	}*/
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

	//Función para obtener la cantidad de enemigos de un tipo
	public int getCantidadEnemigosTipo(int tipoEne) {
		return contadoresEnemigosTipo.getOrDefault(tipoEne,0);
	}
	

	
}