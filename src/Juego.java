
public class Juego {
	
	
	//ESTADO
	
	private Jugador primerJugador;
	private Jugador segundoJugador;
	private Mazo mazo;
	private String registroPartidas = "";
	private static int cantidadRondas = 1;	//----ver si está bien static
	private final int rondaMaxima; 	//----ver si esta bien final
	private Jugador ganadorRonda = primerJugador; 	//----puedo hacer esto?
	
	
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
	
	private void setGanadorRonda(Jugador ganadorRonda) {	//---Se le agrega funcionamiento de cartas
		this.ganadorRonda = ganadorRonda;
	}

	public int getRondaMaxima() {
		return rondaMaxima;
	}


	//COMPORTAMIENTO
	
	public void jugar(){
		repartirCartas();
		while((getCantidadRondas() <= this.rondaMaxima) && (primerJugador.getTotalCartas() > 0) &&
				(segundoJugador.getTotalCartas() > 0)){
			//mientras no se supere el limite de rondas y que los jugadores no se queden sin cartas
			iniciarRonda();
			cantidadRondas++;
		}
		
	}
	//Para repartir las cartas, primero las mezcla y luego las reparte
	public void repartirCartas(){
			
		mazo.mezclarCartas();
		int totalCartas = mazo.getTamañoMazo(); //debo definir esta constante porque voy sacando cartas
		
		for(int i = 1; i <= totalCartas; i++){
			/*if(mazo.isImpar()){
					-------VER SI APLICA
			}*/
			if(i % 2 != 0)
				primerJugador.addCarta(mazo.getPrimeraCarta());//----ver si tomar o getPrimera
			else
				segundoJugador.addCarta(mazo.getPrimeraCarta());
			//mazo.quitarCarta(mazo.getPrimeraCarta());//----VER cada vez que dá una carta la debe quitar del mazo
		}
		addRegistroPartidas("cantidad de j1"+ primerJugador.getTotalCartas() +" -------\n");
		addRegistroPartidas("cantidad de j1"+ segundoJugador.getTotalCartas() +" -------\n");
			
	}
	//
	public void iniciarRonda(){
		
		Carta cartaPrimerJugador = primerJugador.tomarCarta();
		Carta cartaSegundoJugador = segundoJugador.tomarCarta();
		String atributoAleatorio;
		
		if(getCantidadRondas() == 1)		//-----ver linea 13. Si funciona esto se descarta
			setGanadorRonda(primerJugador);
		
		//VER------Se elige atributo al azar para que jueguen
		if(ganadorRonda == primerJugador)
			atributoAleatorio = ganadorRonda.elegirAtributo(cartaPrimerJugador);//---ver si esta bien
		else
			atributoAleatorio = ganadorRonda.elegirAtributo(cartaSegundoJugador);
		
		Atributo atributoPrimerJugador = cartaPrimerJugador.getAtributoPorNombre(atributoAleatorio);
		Atributo atributoSegundoJugador = cartaSegundoJugador.getAtributoPorNombre(atributoAleatorio);
		addRegistroPartidas("\n j1"+ primerJugador.getTotalCartas());
		addRegistroPartidas("\n j2"+ segundoJugador.getTotalCartas());
		addRegistroInicialRonda(atributoAleatorio, cartaPrimerJugador, cartaSegundoJugador, 
								atributoPrimerJugador, atributoSegundoJugador);
		definirGanadorRonda(cartaPrimerJugador, cartaSegundoJugador, atributoPrimerJugador, atributoSegundoJugador);
		addRegistroFinalRonda();
		
	}
	
	//Completa el registro con los datos iniciales de la ronda
	public void addRegistroInicialRonda(String atributo, Carta cartaJ1, Carta cartaJ2, Atributo atributoJ1, Atributo atributoJ2){
		addRegistroPartidas("\n------- Ronda "+ getCantidadRondas() +" -------\n");
		addRegistroPartidas("\n El jugador "+ ganadorRonda +" selecciona competir por el atributo " +atributo);	
		addRegistroPartidas("\n La carta de "+ primerJugador +" es "+ cartaJ1 +" con "+ atributoJ1);//por redefinir strings
		addRegistroPartidas("\n La carta de "+ segundoJugador +" es "+ cartaJ2 +" con "+ atributoJ2);
	}
	//Completa el registro con los datos finales de la ronda
	public void addRegistroFinalRonda(){
		addRegistroPartidas("\n Gana la ronda " + ganadorRonda +".");
		addRegistroPartidas("\n "+ primerJugador + " posee ahora "+ primerJugador.getTotalCartas()+ " cartas y "+
							segundoJugador +" posee ahora "+ segundoJugador.getTotalCartas()+" cartas \n");
	}

	//Agrega el string para imprimir las partidas
	public void addRegistroPartidas(String nuevoRegistro) {
		this.registroPartidas += nuevoRegistro;
	}
	
	//Definir ganador de la ronda
	public void definirGanadorRonda(Carta cartaJ1, Carta cartaJ2, Atributo atributoJ1, Atributo atributoJ2){
		
		int comparacionValorAtributos = atributoJ1.compareTo(atributoJ2);
		if(comparacionValorAtributos == 0){
			primerJugador.moverAlFinalDelMazo(cartaJ1);
			segundoJugador.moverAlFinalDelMazo(cartaJ1);
			addRegistroPartidas("Hubo empate");	//-----ver si agregar este detalle o no
		}
		else{
			if(comparacionValorAtributos > 0)
				setGanadorRonda(primerJugador);
			else
				setGanadorRonda(segundoJugador);
			recibirCartas(cartaJ1, cartaJ2);
			//ver aca de un if q saque la carta de su mazo sino ganó
		}
	}
	
	//El ganador recibe cartas
	public void recibirCartas(Carta cartaJ1, Carta cartaJ2){
		ganadorRonda.moverAlFinalDelMazo(cartaJ1);
		ganadorRonda.moverAlFinalDelMazo(cartaJ2);
	}

	
}
