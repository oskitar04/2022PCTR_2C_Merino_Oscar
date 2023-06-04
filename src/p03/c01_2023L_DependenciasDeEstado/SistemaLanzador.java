package p03.c01_2023L_DependenciasDeEstado;
import java.util.concurrent.TimeUnit;

public class SistemaLanzador {
	
	public static void main(String[] args) {
		
		
		//TODO VARIABLES 
			// TODO Juego
		Juego enemigo = new Juego(); //Parentesis por que es un objeto
		//enemigo.ActividadEnemiga(1, interfaz); //Esto es para que llame a la puerta de la clase Parque del metodo entrarAlParque
		
		Juego aliado = new Juego(); //Parentesis por que es un objeto
		//aliado.ActividadAliada(2, interfaz); //Esto es para que llame a la puerta de la clase Parque del metodo entrarAlParque
		
		IJuego personaje = null;
		IJuego interfaz = null;
		
		// TODO Crear los hilos
		// TODO Lanzar los hilos
		
		Thread hilo_Enemigo = new Thread(new ActividadEnemiga(1, personaje));
		hilo_Enemigo.start();
		Thread hilo_Aliado = new Thread(new ActividadEnemiga(2, interfaz));
		hilo_Aliado.start();
		
		
	}

}
