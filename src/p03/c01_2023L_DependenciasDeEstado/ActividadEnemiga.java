package p03.c01_2023L_DependenciasDeEstado;

import java.util.concurrent.TimeUnit;

public class ActividadEnemiga implements Runnable {// El implements es para que sea un clase hilo

	// TODO Parque
	private int tipoEne; // Es un entero para los tipos de enemigo

	// TODO Puerta
	private IJuego Juego; // Es un tipo IJuego del interfaz

	// TODO Constructor

	public ActividadEnemiga(int tipoEne, IJuego Juego) {
		this.tipoEne = tipoEne; // El this se utiliza para referirme a mi clase
		this.Juego = Juego;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			Juego.generarEnemigo(tipoEne);
			int mimir = (int) Math.random() * 5 + 1;
			try {
				System.out.println("El Enemigo se dormirá durante " + mimir + " segundos");
				// La siguiente forma es la que pide en la practica de segunda convocatoria
				TimeUnit.MILLISECONDS.sleep(mimir * 1000);
				System.out.println("El Enemigo ha dormido ya ENEMIGO");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
