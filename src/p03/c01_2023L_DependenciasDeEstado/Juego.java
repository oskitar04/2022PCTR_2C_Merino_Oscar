package p03.c01_2023L_DependenciasDeEstado;

import java.util.Hashtable; //Esto es para improtar el hashtable

public class Juego implements IJuego{//Se implementa la interfaz juego
	
	// TODO Nº de enemigos
	// TODO Nº de enemigos/tipo Hashtable<String, Integer>    --El hashtable es un diccionario de datos

	private int EnemigosTotales;
	private Hashtable<String, Integer> EnemigosTipo; //El nombre del hashtable es PersonasPuerta
	
	
	
	public Juego() {//Esto es el metodo constructor, no tiene void ni int ni su madre
		
		EnemigosTotales = 0;
		
		EnemigosTipo = new Hashtable <>(); //Esto es un uevo hashtable, al ser un nuevo objeto se ponen parentesis, y los <> es por el hashtable, no hace falta poner nada en el parentesis por que va vacío		
	}
	//@Override
	public synchronized void generarEnemigo(IJuego genEne) {//El synchronized se usa para sincronizar a la hora de contar
		
		// TODO Inicializar claves (del diccionario)
		//Primero comprobar que claves hay
		/*if(EnemigosTipo.containsKey(genEne)==false) {
			EnemigosTipo.put(genEne, 0); //En caso de que la puerta no exista, esto la crea, el 0 es por que no tenemos personas que hayan entrado por la puerta, la puerta se acaba de crear. El presi la ha inagurado
			//El put es para meter valores
		}*/
		if(EnemigosTipo.containsKey(genEne)==true) {
			EnemigosTipo.put(genEne, 1);
		}
		
		
		// TODO Actualizar los contadores
		EnemigosTotales = EnemigosTotales + 1;
		
		int gente = EnemigosTipo.get(genEne); //El get en este caso solo es para el hashtable
		//EnemigosTipo.put(genEne, (gente+1)); //Esto lo actualiza y hace que entre la gente en este caso
		System.out.println(gente);
		
		// TODO Mensaje
		
		if(EnemigosTipo.get(genEne) == null) {
			EnemigosTipo.put(genEne, 0);
		}
		
		Integer EnemigosT = EnemigosTipo.get(genEne);
		EnemigosT = EnemigosT + 1;
		//EnemigosTipo.put(genEne, contPuerta);
		
		/*float tiempo = System.currentTimeMillis();
		tiempo = tiempo/2;
		*/ //Tiempo de entrada a la puerta
		//imprimirInfo(genEne);
		
		// TODO Comprobar el invariante
		//checkInvariante();
		//Falta declararla
		/*protected void checkInvariante(){
			assert suamrContadorPuerta() == NroPerTot : "INV la suma";
		}
		
		private int sumarContadorPuerta() {
			return;
		}
		*/
	}
	
	private void imprimirInfo(String puerta) {
		System.out.println("Entrada al parque por puerta " + puerta);
		System.out.println("--> Personas en el parque " + NroPerTot + " tiempo: Nulo ");
	}
	@Override //Se implementan los metodos de la Interfaz Juego
	public void generarEnemigo(int genEne) {
		// TODO Auto-generated method stub
		Juego.get(generarEnemigo);
	}
	@Override
	public void eliminarEnemigo(int eliEne) {
		// TODO Auto-generated method stub
		
	}

	

	
}
