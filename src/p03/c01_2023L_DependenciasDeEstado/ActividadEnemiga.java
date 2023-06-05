package p03.c01_2023L_DependenciasDeEstado;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ActividadEnemiga implements Runnable {// El implements es para que sea un clase hilo

	// TODO Parque
	private int tipoEnemigo; // Es un entero para los tipos de enemigo

	// TODO Puerta
	private IJuego iJuego; // Es un tipo IJuego del interfaz

	// TODO Constructor

	public ActividadEnemiga(int tipoEnemigo, IJuego iJuego) {
		this.tipoEnemigo = tipoEnemigo; // El this se utiliza para referirme a mi clase
		this.iJuego = iJuego;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 8; i++) {
			int mimir = (int) Math.random() * 5 + 1;
			// this.juego.iJuego(tipoEne);
			try {
				System.out.println("El Enemigo se dormirá durante " + mimir + "milisegundos");
				// La siguiente forma es la que pide en la practica de segunda convocatoria
				TimeUnit.MILLISECONDS.sleep(mimir * 1000);
				System.out.println("El Enemigo ha dormido ya");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
