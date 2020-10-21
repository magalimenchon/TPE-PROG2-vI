
public class Juego {
	
	//ATRIBUTOS
	private Jugador primerJugador;
	private Jugador segundoJugador;
	private Mazo mazo;
	//private int 
	private static final int rondaMaxima = 6;
	
	//CONSTRUCTOR
	public Juego(Jugador primerJugador, Jugador segundoJugador, Mazo mazo) {
		this.primerJugador = primerJugador;
		this.segundoJugador = segundoJugador;
		this.mazo = mazo;
	}
	
	
	//FUNCIONALIDADES
	private void repartirCartas(){
		mazo.mezclarCartas();
		
	}
	
	//Iniciar juego
	public void iniciarJuego(){
		repartirCartas();
		
		//jugar();
	}
	
	//Definir ganador de la ronda
	public void definirGanador(){
		
	}
	//Contador de rondas
}
