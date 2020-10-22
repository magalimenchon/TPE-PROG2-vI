
public class Juego {
	
	//ATRIBUTOS
	private Jugador primerJugador;
	private Jugador segundoJugador;
	private Mazo mazo;
	private String registroPartidas;
	private static int cantidadRondas;	//----ver si está bien static
	private final int rondaMaxima; 	//----ver si esta bien final
	private Jugador ganadorRonda;
	
	//CONSTRUCTOR
	
	public Juego(Jugador primerJugador, Jugador segundoJugador, Mazo mazo, int rondaMaxima) {
		super();
		this.primerJugador = primerJugador;
		this.segundoJugador = segundoJugador;
		this.mazo = mazo;
		this.rondaMaxima = rondaMaxima;
	}
	
	//GETTERS & SETTERS
	public Jugador getPrimerJugador() {
		return primerJugador;
	}

	public Jugador getSegundoJugador() {
		return segundoJugador;
	}

	public Mazo getMazo() {
		return mazo;
	}

	public String getRegistroPartidas() {
		return registroPartidas;
	}

	public int getCantidadRondas() {
		return cantidadRondas;
	}

	public Jugador getGanadorRonda() {
		return ganadorRonda;
	}

	public int getRondaMaxima() {
		return rondaMaxima;
	}


	//FUNCIONALIDADES
	
	//Iniciar juego
	public void iniciarJuego(){
		repartirCartas();
		jugar();
	}
	

	//Para repartir las cartas, primero las mezcla y luego las reparte
	private void repartirCartas(){
		
		mazo.mezclarCartas();
		for(int i = 0; i < mazo.getTamañoMazo(); i++){//la primer carta sería la de la posición 0, por eso el jugador 1 rige por par para tener 1 de más
			/*if(mazo.isImpar()){
					-------VER SI APLICA
			}*/
			if(i % 2 == 0)
				primerJugador.addCarta(mazo.getPrimeraCarta());
			else
				segundoJugador.addCarta(mazo.getPrimeraCarta());
			mazo.quitarCarta(mazo.getPrimeraCarta());//----VER cada vez que dá una carta la debe quitar del mazo
		}
		
	}
	
	private void jugar(){
		cantidadRondas = 0;
		while((getCantidadRondas() <= this.rondaMaxima) && (primerJugador.getTotalCartas() > 0) &&
				(segundoJugador.getTotalCartas() > 0)){
			//mientras no se supere el limite de rondas y que los jugadores no se queden sin cartas
			cantidadRondas++;
			iniciarRonda();
		}
		
	}
	//
	public void iniciarRonda(){
		this.addRegistroPartidas("------- Ronda "+ getCantidadRondas() +" -------");
		Carta cartaPrimerJugador = primerJugador.tomarCarta();
		Carta cartaSegundoJugador = segundoJugador.tomarCarta();
		//VER------Se elige atributo al azar para que jueguen
		String atributoAleatorio = ganadorRonda.elegirAtributo(ganadorRonda.tomarCarta());//---ver si esta bien
		
	}
	
	//Agrega el string para imprimir las partidas
	//sumo un registro al historial de movimientos del juego
	public void addRegistroPartidas(String nuevoRegistro) {
		this.registroPartidas += nuevoRegistro;
	}
	//Definir ganador de la ronda
	public void definirGanador(){
		
	}
	//Contador de rondas

	
}
