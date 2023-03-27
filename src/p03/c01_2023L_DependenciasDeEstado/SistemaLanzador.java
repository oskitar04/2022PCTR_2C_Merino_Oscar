package p03.c01_2023L_DependenciasDeEstado;

public class SistemaLanzador {
	
	public static void main(String[] args) {
		
		//TODO VARIABLES 
			// TODO Parque
		Parque parque = new Parque(); //Parentesis por que es un objeto
		parque.entrarAlParque("A"); //Esto es para que llame a la puerta de la clase Parque del metodo entrarAlParque
		
		// TODO Crear los hilos
		// TODO Lanzar los hilos
		
		Thread hilo_a = new Thread(new ActividadEntradaPuerta(parque, "A"));
		hilo_a.start();
		Thread hilo_b = new Thread(new ActividadEntradaPuerta(parque, "B"));
		hilo_b.start();
		
		
	}

}
