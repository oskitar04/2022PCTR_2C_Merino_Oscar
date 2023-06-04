package p03.c01_2023L_DependenciasDeEstado;
import java.util.concurrent.TimeUnit;
// Las interfaces no se implementan los metodos, solo se definen
public interface IJuego {
	
	public void generarEnemigo(int tipoEne);

	public void eliminarEnemigo(int tipoEne);
}//Tiene que ser publico, por que si no no se puede acceder a ello
