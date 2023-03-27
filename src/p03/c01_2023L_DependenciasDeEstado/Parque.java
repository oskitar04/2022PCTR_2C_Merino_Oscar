package p03.c01_2023L_DependenciasDeEstado;

import java.util.Hashtable; //Esto es para improtar el hashtable

public class Parque implements IParque{//Se implementa la interfaz parque
	
	// TODO Nº de personas totales 
	// TODO Nº de personas/puerta Hashtable<String, Integer>    --El hashtable es un diccionario de datos

	private int NroPerTot;
	private Hashtable<String, Integer> PersonasPuerta; //El nombre del hashtable es PersonasPuerta
	
	public Parque() {//Esto es el metodo constructor, no tiene void ni int ni su madre
		
		NroPerTot = 0;
		
		PersonasPuerta= new Hashtable <>(); //Esto es un uevo hashtable, al ser un nuevo objeto se ponen parentesis, y los <> es por el hashtable, no hace falta poner nada en el parentesis por que va vacío
		
	}
	@Override
	public synchronized void entrarAlParque(String puerta) {//El synchronized se usa para sincronizar a la hora de contar
		
		// TODO Inicializar claves (del diccionario)
		//Primero comprobar que claves hay
		if(PersonasPuerta.containsKey(puerta)==false) {
			PersonasPuerta.put(puerta, 0); //En caso de que la puerta no exista, esto la crea, el 0 es por que no tenemos personas que hayan entrado por la puerta, la puerta se acaba de crear. El presi la ha inagurado
			//El put es para meter valores
		}
		
		
		// TODO Actualizar los contadores
		NroPerTot = NroPerTot + 1;
		
		int gente = PersonasPuerta.get(puerta); //El get en este caso solo es para el hashtable
		PersonasPuerta.put(puerta, (gente+1)); //Esto lo actualiza y hace que entre la gente en este caso
		System.out.println(gente);
		
		// TODO Mensaje
		
		if(PersonasPuerta.get(puerta) == null) {
			PersonasPuerta.put(puerta, 0);
		}
		
		Integer contPuerta = PersonasPuerta.get(puerta);
		contPuerta = contPuerta + 1;
		PersonasPuerta.put(puerta, contPuerta);
		
		/*float tiempo = System.currentTimeMillis();
		tiempo = tiempo/2;
		*/ //Tiempo de entrada a la puerta
		imprimirInfo(puerta);
		
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

	

	
}
