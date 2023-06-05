package p03.c01_2023L_DependenciasDeEstado;

public class SistemaLanzador {
	
	public SistemaLanzador() { //m�todo constructor, DE MOMENTO VACIA PORQUE NO SE QUE TIENE QUE HACER TODAVIA, creo que va vacia
		
	}
	
	public static void main(String[] args) {
		
		//TODO VARIABLES 
			// TODO Juego
		int MAXIMO = 6; //Ponemos un numero cualquiera para evitar el error
		int TOTAL = 0;
		IJuego partida = new Juego(MAXIMO,TOTAL); 

		// TODO Lanzar los hilos
		
		for(int i = 0; i < MAXIMO; i++){
			// TODO Crear los hilos y postreriormente lanzarlos
			Thread generar = new Thread(new ActividadEnemiga(i, partida));
			generar.start();
			Thread eliminar = new Thread(new ActividadAliada(i,partida));
			eliminar.start();
			
		}
		
		System.out.println("Prueba de que sale algo por pantalla para comenzar la partida");
		
	}

}
