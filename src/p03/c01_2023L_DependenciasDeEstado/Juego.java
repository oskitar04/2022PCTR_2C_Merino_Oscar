package p03.c01_2023L_DependenciasDeEstado;
import java.util.concurrent.TimeUnit;

import java.util.Hashtable; //Esto es para improtar el hashtable

public class Juego implements IJuego{//Se implementa la interfaz juego
	
	// TODO Nº de enemigos
	// TODO Nº de enemigos/tipo Hashtable<Integer, Integer>    --El hashtable es un diccionario de datos
	// TODO Nº de enemigos eliminados/tipo Hashtable<Integer, Integer>

	private int EnemigosTotales;
	private Hashtable<Integer, Integer> EnemigosTipo; //El nombre del hashtable es PersonasPuerta
	private Hashtable<Integer, Integer> EnemigosEliminadosTipo;
	
	
	
	public Juego() {//Esto es el metodo constructor, no tiene void ni int ni su madre
		
		EnemigosTotales = 0;
		
		EnemigosTipo = new Hashtable <>(); //Esto es un nuevo hashtable, al ser un nuevo objeto se ponen parentesis, y los <> es por el hashtable, no hace falta poner nada en el parentesis por que va vacío
		
		EnemigosEliminadosTipo = new Hashtable<>();
	}
	//@Override
	/*public synchronized void generarEnemigo(IJuego tipoEne) {//El synchronized se usa para sincronizar a la hora de contar
		
		// TODO Inicializar claves (del diccionario)
		if(EnemigosTipo.containsKey(tipoEne)==true) {
			int contene = EnemigosTipo.get(tipoEne);
			EnemigosTipo.put(tipoEne, contene + 1);
		}
		
		
		
		// TODO Actualizar los contadores
		EnemigosTotales = EnemigosTotales + 1;
		
		int gente = EnemigosTipo.get(tipoEne); //El get en este caso solo es para el hashtable
		//EnemigosTipo.put(genEne, (gente+1)); //Esto lo actualiza y hace que entre la gente en este caso
		System.out.println(gente);
		
		// TODO Mensaje
		
		if(EnemigosTipo.get(tipoEne) == null) {
			EnemigosTipo.put(tipoEne, 0);
		}
		//EnemigosTipo.put(genEne, contPuerta);
		
		
		
		float tiempo = System.currentTimeMillis();
		tiempo = tiempo/2;
		//Tiempo de entrada a la puerta
		//imprimirInfo(genEne);
		
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
	
	/*private void imprimirInfo(String puerta) {
		System.out.println("Entrada al parque por puerta " + puerta);
		System.out.println("--> Personas en el parque " + NroPerTot + " tiempo: Nulo ");
	}*/
	@Override //Se implementan los metodos de la Interfaz Juego
	public synchronized void generarEnemigo(int tipoEne) {
		// TODO Auto-generated method stub
		if(EnemigosTipo.containsKey(tipoEne)) {
			int cantidad = EnemigosTipo.get(tipoEne);
			EnemigosTipo.put(tipoEne, cantidad + 1);
		}else {
			EnemigosTipo.put(tipoEne,1);
		}
	}
	@Override
	public synchronized void eliminarEnemigo(int tipoEne) {
		// TODO Auto-generated method stub
		if(EnemigosTipo.containsKey(tipoEne)) {
			int cantidad = EnemigosTipo.get(tipoEne);
			if(cantidad > 1) {
				EnemigosTipo.put(tipoEne, cantidad - 1);
			}else {
				EnemigosTipo.remove(tipoEne);
			}
		}
		
	}

	//Función para obtener la cantidad de enemigos de un tipo
	public int getCantidadEnemigosTipo(int tipoEne) {
		return EnemigosTipo.getOrDefault(tipoEne,0);
	}
	

	
}
