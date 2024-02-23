package p03.c01_2023L_DependenciasDeEstado;
public class SistemaLanzador {
	
	public SistemaLanzador() { //método constructor, DE MOMENTO VACIA PORQUE NO SE QUE TIENE QUE HACER TODAVIA, creo que va vacia
		
	}
	
	public static void main(String[] args) {
		
		//TODO VARIABLES 
			// TODO Juego
		int MAXIMO = 5; //Ponemos un numero para definir un maximo
		int TOTAL = 4;
		IJuego partida = new Juego(TOTAL, MAXIMO); 

		// TODO Lanzar los hilos
		
		for(int i = 0; i < MAXIMO; i++){
			// TODO Crear los hilos y postreriormente lanzarlos
			Thread generar = new Thread(new ActividadEnemiga(i, partida));
			Thread eliminar = new Thread(new ActividadAliada(i, partida));

			generar.start();
			eliminar.start();
			
		}
	}
}
