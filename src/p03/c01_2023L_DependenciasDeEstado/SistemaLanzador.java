package p03.c01_2023L_DependenciasDeEstado;

public class SistemaLanzador {
	
	public SistemaLanzador() { //método constructor, DE MOMENTO VACIA PORQUE NO SE QUE TIENE QUE HACER TODAVIA, creo que va vacia
		
	}
	
	public static void main(String[] args) {
		
		//TODO VARIABLES 
			// TODO Juego
		IJuego partida = new Juego(4); //Ponemos un numero cualquiera para evitar el error
		
		//IJuego enemigo = new ActividadEnemiga(int tipoEnemigo, IJuego iJuego);
		
		System.out.println("Prueba de que sale algo por pantalla para comenzar la partida");

		// TODO Lanzar los hilos
		
		for(int i = 0; i < Integer.parseInt(args[0]); i++){
			// TODO Crear los hilos y postreriormente lanzarlos
			Thread generar = new Thread(new ActividadEnemiga(i, partida));
			generar.start();
			Thread eliminar = new Thread(new ActividadAliada(i,partida));
			eliminar.start();
			
		}
		
	}

}
