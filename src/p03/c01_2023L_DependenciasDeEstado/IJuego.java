package p03.c01_2023L_DependenciasDeEstado;
// Las interfaces no se implementan los metodos, solo se definen
public interface IJuego {
	
	public void generarEnemigo(int genEne);

	public void eliminarEnemigo(int eliEne);
}//Tiene que ser publico, por que si no no se puede acceder a ello
