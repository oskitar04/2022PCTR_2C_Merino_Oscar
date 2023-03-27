package p03.c01_2023L_DependenciasDeEstado;
import java.util.logging.Logger;
import java.util.logging.Level;


public class ActividadEntradaPuerta implements Runnable {//El implements es para que sea un clase hilo

	// TODO Parque
	private Parque el_parque; //Es un objeto, asi que lo declaro asi

	// TODO Puerta
	private String puerta; //Es un string, cadena de caracteres
	
	// TODO Constructor
	
	public ActividadEntradaPuerta(Parque el_parque, String puerta) {
		this.el_parque = el_parque; //El this se utiliza para referirme a mi clase
		this.puerta = puerta;
	}
	
	@Override
	public void run() {
		// TODO Entrar al parque 20 veces
		for(int i=0; i < 20; i++) {
			//this.el_parque.entrarAlParque(puerta);//Entras al parque con la puerta
			int mimir = (int) Math.random()*5+1;
			try {
				// TODO Dormir aleatorio 1-5s	
				Thread.sleep(mimir*1000);
				el_parque.entrarAlParque(puerta);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}		
		}
		//Ese "this." sobra, pero conviene ponerle, por que soy noob
		Logger.getGlobal().log(Level.INFO,"Finalizadaentrada por la puerta" + puerta);
		return;
		
		

	}
/*	public void DormirHilo{
		Random numero = new Random();
		int mimir = numero.nextInt(4000) + 1000; //El 100 es por si da 0 para que se le sume  el segundo
        System.out.println("El hilo se dormirá durante " + mimir + " milisegundos");
        Thread.sleep(mimir); // Duerme el hilo durante el tiempo generado
        System.out.println("El hilo ha despertado");
	}
	*/
		
		//ACABAR ESTA PARTE
		//Thread.sleep(random(1000-5000)));
} 
