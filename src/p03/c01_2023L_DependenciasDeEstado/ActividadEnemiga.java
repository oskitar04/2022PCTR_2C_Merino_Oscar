package p03.c01_2023L_DependenciasDeEstado;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.logging.Level;




public class ActividadEnemiga implements Runnable {//El implements es para que sea un clase hilo

	// TODO Parque
	private int tipoEnemigo; //Es un entero para los tipos de enemigo

	// TODO Puerta
	private IJuego iJuego; //Es un tipo IJuego del interfaz
	
	private int MAXENEMIGOS; //Numero maximo de enemigos
	private int MINENEMIGOS;
	private SistemaLanzador sistemalanzador;
	// TODO Constructor 
	
	public ActividadEnemiga(int tipoEnemigo, IJuego iJuego) {
		this.tipoEnemigo = tipoEnemigo; //El this se utiliza para referirme a mi clase
		this.iJuego = iJuego;
	}
	
	@Override
	public void run() {
		//this.sistemalanzador = sistemalanzador;
		// TODO Auto-generated method stub
		for(int i = 0; i< MAXENEMIGOS ; i++) {
			int mimir = (int) Math.random()*5+1;
			//this.juego.iJuego(tipoEne);
			try {
				//this.el_parque.entrarAlParque(puerta);
				// TODO Dormir aleatorio 1-5s	
				//Thread.sleep(mimir*1000);
				System.out.println("El Enemigo se dormirá durante " + mimir + "milisegundos");
				//La siguiente forma es la que pide en la practica de segunda convocatoria
				TimeUnit.MILLISECONDS.sleep(mimir*1000);
				System.out.println("El Enemigo ha dormido ya");
				
				//sistemaLanzador.hilo_enemigo(puerta);
				//sistemalanzador.interfaz(); //MIRAR ESTO A VER COMO LO ARREGLO
			}catch(InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}
	/*
		Logger.getGlobal().log(Level.INFO,"Finalizadaentrada por la puerta" + puerta);
		return;
		
		

	}
*/
/*	public void DormirHilo{
		Random numero = new Random();
		int mimir = numero.nextInt(4000) + 1000; //El 100 es por si da 0 para que se le sume  el segundo
        System.out.println("El hilo se dormirá durante " + mimir + " milisegundos");
        Thread.sleep(mimir); // Duerme el hilo durante el tiempo generado
        System.out.println("El hilo ha despertado");
	}
	*/
		

} 
