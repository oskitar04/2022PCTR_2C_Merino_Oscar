package p03.c01_2023L_DependenciasDeEstado;

import java.util.concurrent.TimeUnit;

public class ActividadAliada implements Runnable {// El implements es para que sea un clase hilo

	// TODO Parque
	private int tipoEne; // Es un objeto, asi que lo declaro asi

	// TODO Puerta
	private IJuego Juego; // Es un tipo IJuego

	// TODO Constructor

	public ActividadAliada(int tipoEne, IJuego Juego) {
		this.tipoEne = tipoEne; // El this se utiliza para referirme a mi clase
		this.Juego = Juego;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				// TODO Dormir aleatorio 1-5s
				int mimir = (int) Math.random() * 5 + 1;
				Juego.eliminarEnemigo(tipoEne);
				TimeUnit.MILLISECONDS.sleep(mimir * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
