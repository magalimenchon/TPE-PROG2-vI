import java.util.ArrayList;


public class Jugador {
	//ATRIBUTOS
	private String nombre;
	private Mazo cartas;
	
	//CONSTRUCTOR
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.cartas = new Mazo();
	}
	
	//GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}
	
	//FUNCIONALIDADES
	
	
	//OVERRIDES	
	@Override
	public String toString() {
		return nombre;
	}


	
}
